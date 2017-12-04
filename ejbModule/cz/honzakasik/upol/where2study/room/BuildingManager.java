package cz.honzakasik.upol.where2study.room;

import java.util.List;

import javax.ejb.Local;

@Local
public interface BuildingManager {
	
	Building getBuildingById(String buildingId);
		
	List<Building> getAllBuildings();
	
	void removeAllBuildings();
	
	void removeBuilding(Building building);
	
	void createBuilding(Building building);

}
