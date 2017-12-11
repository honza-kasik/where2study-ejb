package cz.honzakasik.upol.where2study.schedule;

import javax.ejb.Local;

/**
 * Abstraction over handling event related database tasks
 */
@Local
public interface EventManager {

	/**
	 * Find event by its id
	 * @param id id of event
	 * @return found event or null
	 */
	Event getEventById(int id);
	
	/**
	 * Persist event to database
	 * @param event event to persists
	 */
	void createEvent(Event event);
	
	/**
	 * Remove event from database
	 * @param event event to remove
	 */
	void removeEvent(Event event);
	
	/**
	 * Remove all events from database
	 */
	void removeAllEvents();
}
