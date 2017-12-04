package cz.honzakasik.upol.where2study.room;

import java.time.LocalTime;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.resteasy.spi.NotImplementedYetException;

import cz.honzakasik.upol.where2study.Constants;
import cz.honzakasik.upol.where2study.users.User;

@Stateless
public class RoomManagerImpl implements RoomManager {
	
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
		return getAllFreeRoomsAtTime(LocalTime.now(), Calendar.getInstance().get(Calendar.DAY_OF_WEEK));
	}

	@Override
	public List<Room> getAllFreeRoomsAtTime(LocalTime time, int dayOfWeek) {
		return getAllRooms().stream()
			.filter(r -> !r.getSchedule().isThereAnyEventRunningAtTime(time, dayOfWeek))
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
	public List<Room> getAllFreeRoomsAtTimeBasedOnUserPrefs(User user, LocalTime time, int dayofWeek) {
		throw new NotImplementedYetException();
	}

	@Override
	public List<Room> getAllFreeRoomsNowBasedOnUserPrefs(User user) {
		throw new NotImplementedYetException();
	}

}
