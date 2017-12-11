package cz.honzakasik.upol.where2study.users;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import cz.honzakasik.upol.where2study.room.Building;
import cz.honzakasik.upol.where2study.room.Department;
import cz.honzakasik.upol.where2study.room.Room;

/**
 * Abstraction over user
 */
@Entity
public class User implements Serializable {
	
	private static final long serialVersionUID = 7321430818740933446L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String email;
	private String firstName;
	private String lastName;
	
	private String passwordHash;
	
	private boolean isAdmin;
	
	@ManyToMany 
	private Set<Building> prefferedBuildings;
	
	@ManyToMany  
	private Set<Department> prefferedDepartments;
	
	@ManyToMany
	private Set<Room> prefferedRooms;

	/**
	 * Create new instance
	 */
	public User() {
	}

	/**
	 * Get user's email
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Set user's email
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Get user's first name
	 * @return
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Set user's first name
	 * @param firstname
	 */
	public void setFirstName(String firstname) {
		this.firstName = firstname;
	}

	/**
	 * Get user's last name
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Set user's last name
	 * @param lastname
	 */
	public void setLastName(String lastname) {
		this.lastName = lastname;
	}

	/**
	 * Get user's password hash
	 * @return
	 */
	public String getPasswordHash() {
		return passwordHash;
	}

	/**
	 * Set user's password hash
	 * @param passwordHash
	 */
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	/**
	 * Get buildings preferred by user - buildings among which the search will be made
	 * @return
	 */
	public Set<Building> getPrefferedBuildings() {
		return prefferedBuildings;
	}

	/**
	 * Set preferred buildings
	 * @param prefferedBuildings
	 */
	public void setPrefferedBuildings(Set<Building> prefferedBuildings) {
		this.prefferedBuildings = prefferedBuildings;
	}

	/**
	 * Get preferred departments by user - departments among which the search will be made
	 * @return
	 */
	public Set<Department> getPrefferedDepartments() {
		return prefferedDepartments;
	}

	/**
	 * Set preferred departments
	 * @param prefferedDepartments
	 */
	public void setPrefferedDepartments(Set<Department> prefferedDepartments) {
		this.prefferedDepartments = prefferedDepartments;
	}

	/**
	 * Get preferred rooms by user - rooms among which the search will be made
	 * @return
	 */
	public Set<Room> getPrefferedRooms() {
		return prefferedRooms;
	}

	/**
	 * Set preferred rooms
	 * @param prefferedRooms
	 */
	public void setPrefferedRooms(Set<Room> prefferedRooms) {
		this.prefferedRooms = prefferedRooms;
	}

	/**
	 * get user's id
	 * @return
	 */
	public int getId() {
		return id;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		result = prime * result + (isAdmin ? 1231 : 1237);
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((passwordHash == null) ? 0 : passwordHash.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (isAdmin != other.isAdmin)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (passwordHash == null) {
			if (other.passwordHash != null)
				return false;
		} else if (!passwordHash.equals(other.passwordHash))
			return false;
		return true;
	}

}
