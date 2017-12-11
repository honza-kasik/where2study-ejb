package cz.honzakasik.upol.where2study.schedule;

import javax.ejb.Local;

/**
 * Abstraction over managing schedule related tasks on database
 */
@Local
public interface ScheduleManager {

	/**
	 * Find schedule by its id
	 * @param id schedule's id
	 * @return found schedule or null
	 */
	Schedule getScheduleById(int id);
	
	/**
	 * Find schedule by building id and room number
	 * @param buildingAbbr id of building
	 * @param roomNumber room number
	 * @return schedule for specified room
	 */
	Schedule getScheduleByBuildingAndRoomNumber(String buildingAbbr, String roomNumber);
	
	/**
	 * Persist schedule
	 * @param schedule to persist
	 */
	void createSchedule(Schedule schedule);
	
	/**
	 * Remove schedule
	 * @param schedule schedule to remove
	 */
	void removeSchedule(Schedule schedule);
	
	/**
	 * Remove all schedules
	 */
	void removeAllSchedules();
}
