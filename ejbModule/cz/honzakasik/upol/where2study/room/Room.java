package cz.honzakasik.upol.where2study.room;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import cz.honzakasik.upol.where2study.schedule.Schedule;

/**
 * Abstraction over room
 */
@Entity
public class Room {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="building_id")
	private Building building;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="department_id")
	private Department department;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="schedule_id")
	private Schedule schedule;
	
	private String roomNumber;
	private String doorNumber;
	private String floor;
	
	private int type;
	private boolean isInCommonFund;
	private int capacity;
	private String note;

	private Room(Builder builder) {
		this.roomNumber = builder.roomNumber;
		this.doorNumber = builder.doorNumber;
		this.floor = builder.floor;
		this.type = builder.type;
		this.building = builder.building;
		this.department = builder.department;
		this.isInCommonFund = builder.isInCommonFund;
		this.capacity = builder.capacity;
		this.note = builder.note;
		this.schedule = builder.schedule;
	}

	public Room() {
	}
	

	public int getId() {
		return id;
	}

	/**
	 * Get identification number of room (as identified in STAG)
	 * @return identification number of room
	 */
	public String getRoomNumber() {
		return roomNumber;
	}

	/**
	 * Get number of door to room (STAG verbatim)
	 * @return door number
	 */
	public String getDoorNumber() {
		return doorNumber;
	}

	/**
	 * Get floor on which the room is located
	 * @return room's floor
	 */
	public String getFloor() {
		return floor;
	}

	/**
	 * Get type of the room, see {@link RoomType}
	 * @return type of a room
	 */
	public int getType() {
		return type;
	}

	/**
	 * Get building in which the room is located
	 * @return building in which the room is located
	 */
	public Building getBuilding() {
		return building;
	}

	/**
	 * Get department (organizational unit) to which the room belongs
	 * @return
	 */
	public Department getDepartment() {
		return department;
	}

	/**
	 * Return true, if room belongs to common fund. This means, that this room can be used by various departments.
	 * @return true if room belong to common fund, false otherwise
	 */
	public boolean isInCommonFund() {
		return isInCommonFund;
	}

	/**
	 * Get capacity of room (e.g. how many people will fit in...)
	 * @return capacity of room
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * There is a column for note in STAG, here you can get its content
	 * @return note from STAG
	 */
	public String getNote() {
		return note;
	}

	/**
	 * Get schedule of this room
	 * @return schedule
	 */
	public Schedule getSchedule() {
		return schedule;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((building == null) ? 0 : building.hashCode());
		result = prime * result + capacity;
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((doorNumber == null) ? 0 : doorNumber.hashCode());
		result = prime * result + ((floor == null) ? 0 : floor.hashCode());
		result = prime * result + id;
		result = prime * result + (isInCommonFund ? 1231 : 1237);
		result = prime * result + ((note == null) ? 0 : note.hashCode());
		result = prime * result + ((roomNumber == null) ? 0 : roomNumber.hashCode());
		result = prime * result + ((schedule == null) ? 0 : schedule.hashCode());
		result = prime * result + type;
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
		Room other = (Room) obj;
		if (building == null) {
			if (other.building != null)
				return false;
		} else if (!building.equals(other.building))
			return false;
		if (capacity != other.capacity)
			return false;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (doorNumber == null) {
			if (other.doorNumber != null)
				return false;
		} else if (!doorNumber.equals(other.doorNumber))
			return false;
		if (floor == null) {
			if (other.floor != null)
				return false;
		} else if (!floor.equals(other.floor))
			return false;
		if (id != other.id)
			return false;
		if (isInCommonFund != other.isInCommonFund)
			return false;
		if (note == null) {
			if (other.note != null)
				return false;
		} else if (!note.equals(other.note))
			return false;
		if (roomNumber == null) {
			if (other.roomNumber != null)
				return false;
		} else if (!roomNumber.equals(other.roomNumber))
			return false;
		if (schedule == null) {
			if (other.schedule != null)
				return false;
		} else if (!schedule.equals(other.schedule))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Room [id=" + id + ", building=" + building + ", department=" + department + ", schedule=" + schedule
				+ ", roomNumber=" + roomNumber + ", doorNumber=" + doorNumber + ", floor=" + floor + ", type=" + type
				+ ", isInCommonFund=" + isInCommonFund + ", capacity=" + capacity + ", note=" + note + "]";
	}

	/**
	 * A builder for {@link Room} (as in builder design pattern)
	 */
	public static final class Builder {

		private String roomNumber;
		private String doorNumber;
		private String floor;
		private int type;
		private Building building;
		private Department department;
		private boolean isInCommonFund;
		private int capacity;
		private String note;
		private Schedule schedule;

		/**
		 * Set room number to builder
		 * @param roomNumber room number from STAG
		 */
		public Builder roomNumber(String roomNumber) {
			this.roomNumber = roomNumber;
			return this;
		}

		/**
		 * Set door number to builder
		 * @param doorNumber door number from STAG
		 */
		public Builder doorNumber(String doorNumber) {
			this.doorNumber = doorNumber;
			return this;
		}

		/**
		 * Set floor on which the room is located
		 * @param floor the room floor
		 */
		public Builder floor(String floor) {
			this.floor = floor;
			return this;
		}

		/**
		 * Set type of the room, see {@link RoomType}
		 * @param type type of the room
		 */
		public Builder type(int type) {
			this.type = type;
			return this;
		}

		/**
		 * Set building in which the room is located
		 * @param building rooms building
		 */
		public Builder building(Building building) {
			this.building = building;
			return this;
		}

		/**
		 * Set department to which this room belongs
		 * @param department
		 */
		public Builder department(Department department) {
			this.department = department;
			return this;
		}

		/**
		 * Set true if room is in common fund
		 * @param isInCommonFund
		 */
		public Builder inCommonFund(boolean isInCommonFund) {
			this.isInCommonFund = isInCommonFund;
			return this;
		}

		/**
		 * Set capacity room's capacity
		 * @param capacity
		 */
		public Builder capacity(int capacity) {
			this.capacity = capacity;
			return this;
		}

		/**
		 * Set STAG note
		 * @param note from STAG
		 */
		public Builder note(String note) {
			this.note = note;
			return this;
		}

		/**
		 * Set schedule to room
		 * @param schedule
		 */
		public Builder schedule(Schedule schedule) {
			this.schedule = schedule;
			return this;
		}

		/**
		 * Build {@link Room} using this builder
		 * @return new instance of room
		 */
		public Room build() {
			return new Room(this);
		}

	}

}
