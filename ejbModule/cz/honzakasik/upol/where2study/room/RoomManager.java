package cz.honzakasik.upol.where2study.room;

import java.time.LocalTime;
import java.util.List;

import javax.ejb.Local;

import cz.honzakasik.upol.where2study.users.User;

/**
 * Abstraction over managing rooms in database
 */
@Local
public interface RoomManager {
	
	/**
	 * Find room by its id
	 * @param roomId id of room
	 * @return found room or null
	 */
	Room getRoom(int roomId);
	
	/**
	 * Get all persisted rooms from database
	 * @return list of persisted rooms
	 */
	List<Room> getAllRooms();
	
	/**
	 * Get all rooms, in which there are no events right now
	 * @return all free events now
	 */
	List<Room> getAllFreeRoomsNow();
	
	/**
	 * Get all free rooms at specified time of a day
	 * @param time time of day in which you want to find out which rooms are not occupied
	 * @param dayofWeek day of week (monday to sunday)
	 * @return all non occupied rooms at specified times
	 */
	List<Room> getAllFreeRoomsAtTime(LocalTime time, int dayofWeek);
	
	/**
	 * Get all free rooms at specified time of day filtered based on user preferences
	 * @param user whose preferences are taken into account
	 * @param time time of day in which you want to find out which rooms are not occupied
	 * @param dayofWeek day of week (monday to sunday)
	 * @return all non occupied rooms at specified times
	 */
	List<Room> getAllFreeRoomsAtTimeBasedOnUserPrefs(User user, LocalTime time, int dayofWeek);
	
	
	/**
	 * Get all rooms, in which there are no events right now based on user preferences
	 * @param user whose preferences are taken into account
	 * @return all free events now
	 */
	List<Room> getAllFreeRoomsNowBasedOnUserPrefs(User user);
	
	/**
	 * Persist room to database
	 * @param room room to persist
	 */
	void createRoom(Room room);
	
	/**
	 * Remove room from database
	 * @param room room to remove
	 */
	void removeRoom(Room room);
	
	/**
	 * Remove all rooms from database
	 */
	void removeAllRooms();

}
