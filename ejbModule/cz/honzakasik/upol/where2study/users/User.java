package cz.honzakasik.upol.where2study.users;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import cz.honzakasik.upol.where2study.room.Building;
import cz.honzakasik.upol.where2study.room.Department;
import cz.honzakasik.upol.where2study.room.Room;

@Entity
public class User {
	
	private String email;
	private String firstname;
	private String lastname;
	
	private String passwordHash;
	
	@ManyToMany(cascade = CascadeType.ALL)  
    @JoinTable(name = "building_user",
			    joinColumns = @JoinColumn(name="user_id"), 
			    inverseJoinColumns = @JoinColumn(name="building_id"))  
	private List<Building> preferredBuildings;
	
	@ManyToMany(cascade = CascadeType.ALL)  
    @JoinTable(name = "department_user",
			    joinColumns = @JoinColumn(name="user_id"), 
			    inverseJoinColumns = @JoinColumn(name="department_id"))  
	private List<Department> prefferedDepartments;
	
	@ManyToMany(cascade = CascadeType.ALL)  
    @JoinTable(name = "room_user",
			    joinColumns = @JoinColumn(name="user_id"), 
			    inverseJoinColumns = @JoinColumn(name="room_id"))  
	private List<Room> prefferedRooms;

	public User() {
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

}
