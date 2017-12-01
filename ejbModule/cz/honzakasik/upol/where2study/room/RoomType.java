package cz.honzakasik.upol.where2study.room;

/**
 * Determines a type of a room (laboratory, classroom, workroom...)
 */
public enum RoomType {
	
	UNDEFINED(0), CLASSROOM(2), ATELIER(3), LABORATORY(4), OTHER(5), WORKROOM(9);
	
	private int stagCode;

	private RoomType(int stagCode) {
		this.stagCode = stagCode;
	}

	/**
	 * Get number code used in stag for this type of room
	 * @return number code of room type
	 */
	public int getStagCode() {
		return stagCode;
	}

}
