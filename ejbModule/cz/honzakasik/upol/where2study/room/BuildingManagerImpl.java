package cz.honzakasik.upol.where2study.room;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import cz.honzakasik.upol.where2study.Constants;

@Stateless
public class BuildingManagerImpl implements BuildingManager {
	
	@PersistenceContext(unitName=Constants.DEFAULT_PERSISTENCE_UNIT_NAME);
	private EntityManager em;

	@Override
	public Building getBuildingById(String buildingId) {
		return em.find(Building.class, buildingId);
	}

	@Override
	public List<Building> getAllBuildings() {
		return em.createQuery("select b from Building b", Building.class).getResultList();
	}

	@Override
	public void removeAllBuildings() {
		em.createQuery("delete from Building b").executeUpdate();
	}

	@Override
	public void removeBuilding(Building room) {
		em.remove(room);
	}

	@Override
	public void addBuilding(Building room) {
		em.persist(room);
	}

}
