package cz.honzakasik.upol.where2study.room;

import java.time.LocalTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cz.honzakasik.upol.where2study.Constants;
import cz.honzakasik.upol.where2study.TimeUtils;
import cz.honzakasik.upol.where2study.users.User;
import cz.honzakasik.upol.where2study.users.UserManager;

@Stateless
public class RoomManagerImpl implements RoomManager {
	
	private static final Logger log = LoggerFactory.getLogger(RoomManagerImpl.class);
	
	@Inject
	private UserManager UserManager;
	
	@PersistenceContext(unitName=Constants.DEFAULT_PERSISTENCE_UNIT_NAME)
	private EntityManager em;

	@Override
	public Room getRoom(int roomId) {
		return em.find(Room.class, roomId);
	}

	@Override
	public List<Room> getAllRooms() {
		return em.createQuery("select r from Room r", Room.class).getResultList();
	}

	@Override
	public List<Room> getAllFreeRoomsNow() {
		return getAllFreeRoomsAtTime(LocalTime.now(), TimeUtils.getDayOfWeekToday());
	}

	@Override
	public List<Room> getAllFreeRoomsAtTime(LocalTime time, int dayOfWeek) {
		return getAllRooms().stream()
			.filter(r -> (r.getType() == 2 || r.getType() == 4) && !r.getSchedule().isThereAnyEventRunningAtTime(time, dayOfWeek))
			.collect(Collectors.toList());
	}

	@Override
	public void createRoom(Room room) {
		em.persist(room);
	}

	@Override
	public void removeRoom(Room room) {
		em.remove(room);
	}

	@Override
	public void removeAllRooms() {
		em.createQuery("delete from Room r").executeUpdate();
	}

	@Override
	public List<Room> getAllFreeRoomsAtTimeBasedOnUserPrefs(User u, LocalTime time, int dayOfWeek) {
		final User user = UserManager.findUser(u.getId());
		final Set<Department> pd = user.getPrefferedDepartments();
		final Set<Room> pr = user.getPrefferedRooms();
		final Set<Building> pb = user.getPrefferedBuildings();
		return getAllFreeRoomsAtTime(time, dayOfWeek)
				.stream()
				.filter(r -> (pb.size() == 0 || pb.contains(r.getBuilding())) && 
							 (pd.size() == 0 || pd.contains(r.getDepartment())) &&
							 (pr.size() == 0 || pr.contains(r)))
				.collect(Collectors.toList());
	}

	@Override
	public List<Room> getAllFreeRoomsNowBasedOnUserPrefs(User user) {
		return getAllFreeRoomsAtTimeBasedOnUserPrefs(user, LocalTime.now(), TimeUtils.getDayOfWeekToday());
	}

}
