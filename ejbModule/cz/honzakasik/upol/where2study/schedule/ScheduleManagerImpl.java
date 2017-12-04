package cz.honzakasik.upol.where2study.schedule;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import cz.honzakasik.upol.where2study.Constants;

@Stateless
public class ScheduleManagerImpl implements ScheduleManager {
	
	@PersistenceContext(unitName=Constants.DEFAULT_PERSISTENCE_UNIT_NAME)
	private EntityManager em;

	@Override
	public Schedule getScheduleById(int id) {
		return em.find(Schedule.class, id);
	}

	@Override
	public void createSchedule(Schedule schedule) {
		em.persist(schedule);
	}

	@Override
	public void removeSchedule(Schedule schedule) {
		em.remove(schedule);
	}

	@Override
	public void removeAllSchedules() {
		em.createQuery("delete from Schedule s").executeUpdate();
	}

}
