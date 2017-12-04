package cz.honzakasik.upol.where2study.restclients;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cz.honzakasik.upol.where2study.Constants;
import cz.honzakasik.upol.where2study.TimeUtils;
import cz.honzakasik.upol.where2study.restclients.jaxbmodels.mistnostiinforesponse.GetMistnostiInfoResponse;
import cz.honzakasik.upol.where2study.restclients.jaxbmodels.mistnostiinforesponse.GetMistnostiInfoResponse.MistnostiInfo.MistnostInfo;
import cz.honzakasik.upol.where2study.restclients.jaxbmodels.rozvrhbymistnostresponse.GetRozvrhByMistnostResponse;
import cz.honzakasik.upol.where2study.restclients.jaxbmodels.rozvrhbymistnostresponse.RozvrhovaAkce;
import cz.honzakasik.upol.where2study.room.Building;
import cz.honzakasik.upol.where2study.room.BuildingManager;
import cz.honzakasik.upol.where2study.room.Department;
import cz.honzakasik.upol.where2study.room.DepartmentManager;
import cz.honzakasik.upol.where2study.room.Room;
import cz.honzakasik.upol.where2study.room.RoomManager;
import cz.honzakasik.upol.where2study.schedule.Event;
import cz.honzakasik.upol.where2study.schedule.EventManager;
import cz.honzakasik.upol.where2study.schedule.Schedule;
import cz.honzakasik.upol.where2study.schedule.ScheduleManager;

@Stateful
public class DataDownloaderImpl implements DataDownloader {
	
	private static final Logger log = LoggerFactory.getLogger(DataDownloaderImpl.class);
	
	@Inject
	private RoomManager roomManager;
	
	@Inject 
	private DepartmentManager departmentManager;
	
	@Inject
	private ScheduleManager scheduleManager;
	
	@Inject
	private EventManager eventManager;
	
	@Inject
	private BuildingManager buildingManager;
	
	private InputStream getResponse(String url) throws IOException {
		log.debug("Starting client build");
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target(Constants.BASE_URL_REST_SERVICE + url);
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_XML);
		Response response = invocationBuilder.get();
		if (response.getStatus() != 200) {
			throw new IOException("Failed : HTTP error code : " + response.getStatus());
		} else {
			log.debug("Recieved response with status OK!");
			return response.readEntity(InputStream.class);
		}
	}
	
	private List<GetMistnostiInfoResponse.MistnostiInfo.MistnostInfo> parseMistnostInfoList(InputStream inputStream)
			throws JAXBException {
	    final JAXBContext jaxbContext = JAXBContext.newInstance(GetMistnostiInfoResponse.class);
	    final Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	    return ((GetMistnostiInfoResponse) jaxbUnmarshaller.unmarshal(inputStream)).getMistnostiInfo().getMistnostInfo();
	}
	
	@Override
	public void downloadData() throws IOException, JAXBException, IllegalStateException {
		log.error("Starting download!");
		List<GetMistnostiInfoResponse.MistnostiInfo.MistnostInfo> mistnostInfos = parseMistnostInfoList(
				getResponse("/mistnost/getMistnostiInfo"));
		for (GetMistnostiInfoResponse.MistnostiInfo.MistnostInfo mi : mistnostInfos) {
			final Building building = obtainBuildingForRoom(mi);
			Room room = new Room.Builder()
						.roomNumber(mi.getCisloMistnosti())
						.type(mi.getTypCiselne().intValue())
						.capacity(mi.getKapacita().intValue())
						.doorNumber(mi.getDvereCislo())
						.floor(mi.getPodlazi())
						.building(building)
						.inCommonFund(mi.getSpolecnyFond().equals("ne") ? false : true)
						.department(parseDepartmentInfo(mi))
						.schedule(obtainScheduleForRoom(mi))
						.note(mi.getPoznamka())
						.build();
			building.addRoom(room);
			log.info("Parsed room: '{}'", room.toString());
			//persist the room
			roomManager.createRoom(room);
		}
	}
			
	private Building obtainBuildingForRoom(MistnostInfo mi) {
		final Building persistedBuilding = buildingManager.getBuildingById(mi.getZkrBudovy());
		if (persistedBuilding == null) {
			Building building = new Building(mi.getZkrBudovy(), mi.getUlice(), mi.getObec(), mi.getCisloPopisne());
			buildingManager.createBuilding(building);
			return building;
		} else {
			log.info("Building {} already persisted!", mi.getZkrBudovy());
			return persistedBuilding;
		}
	}

	private List<RozvrhovaAkce> parseRozvrhovaAkceList(InputStream inputStream) throws JAXBException, IOException {
	    final JAXBContext jaxbContext = JAXBContext.newInstance(GetRozvrhByMistnostResponse.class);
	    final Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	    return ((GetRozvrhByMistnostResponse) jaxbUnmarshaller.unmarshal(inputStream)).getRozvrh().getRozvrhovaAkce();
	}

	private Schedule obtainScheduleForRoom(GetMistnostiInfoResponse.MistnostiInfo.MistnostInfo mi)
			throws IOException, JAXBException, IllegalStateException {
		final String buildingId = mi.getZkrBudovy();
		final String roomNumber = mi.getCisloMistnosti();
		log.info("Obtaining schedule for room: '{}-{}'", buildingId, roomNumber);
		final String requestUrl = "/rozvrhy/getRozvrhByMistnost?budova=" + buildingId + "&mistnost=" + roomNumber;
		final List<RozvrhovaAkce> rozvrhoveAkce = parseRozvrhovaAkceList(getResponse(requestUrl));
		if (rozvrhoveAkce == null) {
			throw new IllegalStateException("No data about events scheduled for room were parsed!");
		}
		log.info("Parsed {} events", rozvrhoveAkce.size());
		final List<Event> events = new LinkedList<>();
		for (RozvrhovaAkce ra : rozvrhoveAkce) {
			final Event event = new Event(TimeUtils.timeStringToLocalTime(ra.getHodinaSkutOd()),
					TimeUtils.timeStringToLocalTime(ra.getHodinaSkutDo()),
					TimeUtils.czechStringToDayOfWeek(ra.getDen()));
			eventManager.createEvent(event);
			events.add(event);
		}
		final Schedule schedule = new Schedule(events);
		scheduleManager.createSchedule(schedule);
		return schedule;
	}

	/**
	 * Also ensures, that there will be no persisted duplicities.
	 */
	private Department parseDepartmentInfo(GetMistnostiInfoResponse.MistnostiInfo.MistnostInfo mistnostInfo) {
		final Department persistedDepartment = departmentManager.getDepartmentById(mistnostInfo.getKatedra());
		if (persistedDepartment == null) {
			final Department department = new Department(mistnostInfo.getKatedra(), mistnostInfo.getPracoviste());
			departmentManager.createDepartment(department);
			return department;
		} else {
			log.info("Department '{}' already persisted!", persistedDepartment.getAbbreviation());
			return persistedDepartment;
		}
	}
}
