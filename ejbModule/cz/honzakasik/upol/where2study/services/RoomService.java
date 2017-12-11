package cz.honzakasik.upol.where2study.services;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import cz.honzakasik.upol.where2study.room.Room;
import cz.honzakasik.upol.where2study.room.RoomManager;

@Path("/room")
public class RoomService {
	
	@Inject
	private RoomManager roomManager;
	
	@GET
	@Path("/getallfreeroomsnow")
	@Produces(MediaType.APPLICATION_XML)
	public List<Room> getAllFreeRoomsAsXML() {

		return roomManager.getAllFreeRoomsNow();

	}

}
