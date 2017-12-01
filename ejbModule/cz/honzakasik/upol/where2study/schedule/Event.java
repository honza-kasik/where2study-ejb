package cz.honzakasik.upol.where2study.schedule;

import java.util.Date;

/**
 * Event from room's schedule
 */
public class Event {
	
	private final Date startTime;
	private final Date endTime;
	
	public Event(Date startTime, Date endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}

	/**
	 * Get start time of event
	 * @return start time of event
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * Get end time of event
	 * @return end time of event
	 */
	public Date getEndTime() {
		return endTime;
	}

}
