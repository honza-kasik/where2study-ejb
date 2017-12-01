package cz.honzakasik.upol.where2study.room;

import cz.honzakasik.upol.where2study.schedule.Schedule;

/**
 * Abstraction over room
 */
public class Room {

	private final String roomNumber;
	private final String doorNumber;
	private final String floor;
	private final RoomType type;
	private final Building building;
	private final Department department;
	private final Schedule schedule;
	private final boolean isInCommonFund;
	private final int capacity;
	private final String note;

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
	public RoomType getType() {
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

	/**
	 * A builder for {@link Room} (as in builder design pattern)
	 */
	public static final class Builder {

		private String roomNumber;
		private String doorNumber;
		private String floor;
		private RoomType type;
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
		public Builder type(RoomType type) {
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
