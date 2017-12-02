package cz.honzakasik.upol.where2study.schedule;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 * Abstraction over schedule for room.
 */
@Entity
public class Schedule {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@OneToMany
	@JoinColumn(name="event_id")
	private final List<Event> events;
	
	public Schedule(List<Event> events) {
		this.events = events;
	}

	/**
	 * Find out if there's an event running right now
	 * @return true if there is event running right now, false otherwise
	 */
	public boolean isThereAnyEvenRunningtNow() {
		return isThereAnyEventRunningAtTime(new Date());
	}
	
	/**
	 * Find out if there is event running at specified time
	 * @param date time in which we are finding running event
	 * @return true if there is running event at specified time, false otherwise
	 */
	public boolean isThereAnyEventRunningAtTime(Date date) {
		for (Event event : events) {
			if (date.after(event.getStartTime()) && date.before(event.getEndTime())) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Get next event starting after specified time
	 * @param date time after which the event should start
	 * @return event starting closest to specified time, null if there are no such event
	 * 		   (presumably at the end of a day...)
	 */
	public Event getNextEventStartingAfterTime(Date date) {
		return events.stream()
				.filter((Event e) -> e.getStartTime().after(date))
				.sorted((Event e1, Event e2) -> e1.getStartTime().compareTo(e2.getStartTime()))
				.findFirst()
				.orElseGet(null);
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
	
}
