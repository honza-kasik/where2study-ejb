package cz.honzakasik.upol.where2study.schedule;

import javax.ejb.Local;

@Local
public interface EventManager {

	Event getEventById(int id);
	
	void createEvent(Event event);
	
	void removeEvent(Event event);
	
	void removeAllEvents();
}
