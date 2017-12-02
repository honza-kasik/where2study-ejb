package cz.honzakasik.upol.where2study.schedule;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Event from room's schedule
 */
@Entity
public class Event {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
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
		Event other = (Event) obj;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		return true;
	}
}
