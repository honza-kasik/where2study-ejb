package cz.honzakasik.upol.where2study.services;


import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import cz.honzakasik.upol.where2study.schedule.Schedule;
import cz.honzakasik.upol.where2study.schedule.ScheduleManager;

@Path("/schedule")
public class ScheduleService {
	
	@Inject
	private ScheduleManager scheduleManager;
	
	@GET
	@Path("/{building}/{roomNumber}")
	@Produces(MediaType.APPLICATION_XML)
	public Schedule getScheduleForRoomAsXML(
			@PathParam("building") String building,
			@PathParam("roomNumber") String roomNumber) {

		return scheduleManager.getScheduleByBuildingAndRoomNumber(building, roomNumber);

	}

}
