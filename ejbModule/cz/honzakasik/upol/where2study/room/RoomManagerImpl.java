package cz.honzakasik.upol.where2study.room;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.sun.org.apache.regexp.internal.recompile;

import cz.honzakasik.upol.where2study.Constants;

@Stateless
public class RoomManagerImpl implements RoomManager {
	
	@PersistenceContext(unitName=Constants.DEFAULT_PERSISTENCE_UNIT_NAME);
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
		return getAllFreeRoomsAtTime(new Date());
	}

	@Override
	public List<Room> getAllFreeRoomsAtTime(Date time) {
		getAllRooms().stream()
			.filter(r -> !r.getSchedule().isThereAnyEventRunningAtTime(time))
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

}
