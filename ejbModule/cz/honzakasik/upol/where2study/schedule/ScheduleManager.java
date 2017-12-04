package cz.honzakasik.upol.where2study.schedule;

import javax.ejb.Local;

@Local
public interface ScheduleManager {

	Schedule getScheduleById(int id);
	
	void createSchedule(Schedule schedule);
	
	void removeSchedule(Schedule schedule);
	
	void removeAllSchedules();
}
