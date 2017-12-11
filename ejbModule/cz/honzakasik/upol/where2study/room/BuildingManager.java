package cz.honzakasik.upol.where2study.room;

import java.util.List;

import javax.ejb.Local;

/**
 * Interface describing access to persisted building entities
 */
@Local
public interface BuildingManager {
	
	/**
	 * Find building by ID - abbreviation. E.g. LP for Faculty of nature science on street Trida 17. listopadu
	 * @param buildingId  building abbreviation
	 * @return found building or null
	 */
	Building getBuildingById(String buildingId);
	
	/**
	 * Get all persisted buildings in database
	 * @return all buildings
	 */
	List<Building> getAllBuildings();
	
	/**
	 * Remove all building entities
	 */
	void removeAllBuildings();
	
	/**
	 * Remove building from database
	 * @param building building to remove
	 */
	void removeBuilding(Building building);
	
	/**
	 * Persist database in building
	 * @param building building to be peristed
	 */
	void createBuilding(Building building);

}
