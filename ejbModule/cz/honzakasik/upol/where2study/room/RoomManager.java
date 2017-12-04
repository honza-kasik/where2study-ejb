package cz.honzakasik.upol.where2study.room;

import java.time.LocalTime;
import java.util.List;

import javax.ejb.Local;

import cz.honzakasik.upol.where2study.users.User;

@Local
public interface RoomManager {
	
	Room getRoom(int roomId);
	
	List<Room> getAllRooms();
	
	List<Room> getAllFreeRoomsNow();
	
	List<Room> getAllFreeRoomsAtTime(LocalTime time, int dayofWeek);
	
	List<Room> getAllFreeRoomsAtTimeBasedOnUserPrefs(User user, LocalTime time, int dayofWeek);
	
	List<Room> getAllFreeRoomsNowBasedOnUserPrefs(User user);
	
	void createRoom(Room room);
	
	void removeRoom(Room room);
	
	void removeAllRooms();

}
