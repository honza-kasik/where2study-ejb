package cz.honzakasik.upol.where2study.schedule;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import cz.honzakasik.upol.where2study.Constants;

@Stateless
public class EventManagerImpl implements EventManager {
	
	@PersistenceContext(unitName=Constants.DEFAULT_PERSISTENCE_UNIT_NAME)
	private EntityManager em;

	@Override
	public Event getEventById(int id) {
		return em.find(Event.class, id);
	}

	@Override
	public void createEvent(Event event) {
		em.persist(event);
	}

	@Override
	public void removeEvent(Event event) {
		em.remove(event);

	}

	@Override
	public void removeAllEvents() {
		em.createQuery("delete from Event e").executeUpdate();
	}

}
