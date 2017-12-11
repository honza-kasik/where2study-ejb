package cz.honzakasik.upol.where2study.schedule;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import cz.honzakasik.upol.where2study.Constants;
import cz.honzakasik.upol.where2study.room.Room;

@Stateless
public class ScheduleManagerImpl implements ScheduleManager {
	
	@PersistenceContext(unitName=Constants.DEFAULT_PERSISTENCE_UNIT_NAME)
	private EntityManager em;

	@Override
	public Schedule getScheduleById(int id) {
		final Schedule schedule = em.find(Schedule.class, id);
		schedule.getEvents().size();
		return schedule;
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

	@Override
	public Schedule getScheduleByBuildingAndRoomNumber(String buildingAbbr, String roomNumber) {
		return em.createQuery("select r from Room r WHERE r.roomNumber = :rn and r.building.abbreviation = :ba", Room.class)
			.setParameter("rn", roomNumber)
			.setParameter("ba", buildingAbbr)
			.getSingleResult()
			.getSchedule();
	}

}
