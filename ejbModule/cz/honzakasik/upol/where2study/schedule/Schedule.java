package cz.honzakasik.upol.where2study.schedule;

import java.util.Date;
import java.util.List;

/**
 * Abstraction over schedule for room.
 */
public class Schedule {
	
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
	
}
