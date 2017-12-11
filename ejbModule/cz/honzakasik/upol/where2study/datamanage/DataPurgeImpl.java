package cz.honzakasik.upol.where2study.datamanage;

import javax.ejb.Stateless;
import javax.inject.Inject;

import cz.honzakasik.upol.where2study.room.BuildingManager;
import cz.honzakasik.upol.where2study.room.DepartmentManager;
import cz.honzakasik.upol.where2study.room.RoomManager;
import cz.honzakasik.upol.where2study.schedule.EventManager;
import cz.honzakasik.upol.where2study.schedule.ScheduleManager;

@Stateless
public class DataPurgeImpl implements DataPurge {
	
	@Inject
	private RoomManager roomManager;
	
	@Inject
	private BuildingManager buildingManager;
	
	@Inject
	private DepartmentManager departmentManager;
	
	@Inject
	private ScheduleManager scheduleManager;
	
	@Inject
	private EventManager eventManager;

	@Override
	public void purgeAllPersistedData() {
		roomManager.removeAllRooms();
		buildingManager.removeAllBuildings();
		departmentManager.removeAllDepartments();
		eventManager.removeAllEvents();
		scheduleManager.removeAllSchedules();
	}

}
