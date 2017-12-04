package cz.honzakasik.upol.where2study.room;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Building {
	
	@Id
	private String abbreviation;
	
	private String street;
	private String city;
	private String number;
	
	@OneToMany(mappedBy="building")
	private List<Room> rooms = new LinkedList<>();
	
	public Building() {
	}

	public Building(String abbreviation, String street, String city, String number) {
		this.abbreviation = abbreviation;
		this.street = street;
		this.city = city;
		this.number = number;
	}

	public String getAbbreviation() {
		return abbreviation;
	}
	
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
	
	public void addRoom(Room room) {
		this.rooms.add(room);
	}
	
}
