package cz.honzakasik.upol.where2study.schedule;

import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cz.honzakasik.upol.where2study.TimeUtils;

/**
 * Abstraction over schedule for room.
 */
@Entity
@XmlRootElement
public class Schedule {
	
	private static final Logger log = LoggerFactory.getLogger(Schedule.class);
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@OneToMany(mappedBy = "schedule")
	@XmlElement
	private List<Event> events = new LinkedList<>();
	
	public Schedule() {
	}

	public Schedule(List<Event> events) {
		this.events = events;
	}

	/**
	 * Find out if there's an event running right now
	 * @return true if there is event running right now, false otherwise
	 */
	public boolean isThereAnyEvenRunningtNow() {
		int dayOfWeek = TimeUtils.getDayOfWeekToday();
		return isThereAnyEventRunningAtTime(LocalTime.now(), dayOfWeek);
	}
	
	/**
	 * Find out if there is event running at specified time
	 * @param date time in which we are finding running event
	 * @return true if there is running event at specified time, false otherwise
	 */
	public boolean isThereAnyEventRunningAtTime(LocalTime time, int dayOfWeek) {
		for (Event event : events) {
			if (event.isRunningAtTime(time, dayOfWeek)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Get next event starting after specified time today
	 * @param time time after which the event should start
	 * @return event starting closest to specified time, null if there are no such event
	 * 		   (presumably at the end of a day...)
	 */
	public Event getNextEventStartingAfterTime(LocalTime time) {
		int dayOfWeek = TimeUtils.getDayOfWeekToday();
		return events.stream()
				.filter((Event e) -> e.getDayOfWeek() == dayOfWeek && e.getStartTime().isAfter(time))
				.sorted((Event e1, Event e2) -> e1.getStartTime().compareTo(e2.getStartTime()))
				.findFirst()
				.orElseGet(() -> null);
	}
	
	/**
	 * Get next event starting after specified time
	 * @param time time after which the event should start
	 * @return event starting closest to specified time, null if there are no such event
	 * 		   (presumably at the end of a day...)
	 */
	public Event getNextEventStartingAfterNow() {
		return getNextEventStartingAfterTime(LocalTime.now());
	}

	/**
	 * Get all events included in this schedule
	 * @return list of events
	 */
	public List<Event> getEvents() {
		return events;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((events == null) ? 0 : events.hashCode());
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
		Schedule other = (Schedule) obj;
		if (events == null) {
			if (other.events != null)
				return false;
		} else if (!events.equals(other.events))
			return false;
		return true;
	}

	public void addEvent(Event event) {
		this.events.add(event);
		event.setSchedule(this);		
	}
	
}
