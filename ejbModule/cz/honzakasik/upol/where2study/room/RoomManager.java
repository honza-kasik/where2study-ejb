package cz.honzakasik.upol.where2study.room;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

@Local
public interface RoomManager {
	
	Room getRoom(int roomId);
	
	List<Room> getAllRooms();
	
	List<Room> getAllFreeRoomsNow();
	
	List<Room> getAllFreeRoomsAtTime(Date time);
	
	void createRoom(Room room);
	
	void removeRoom(Room room);
	
	void removeAllRooms();

}
