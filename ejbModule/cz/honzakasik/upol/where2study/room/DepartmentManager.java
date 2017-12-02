package cz.honzakasik.upol.where2study.room;

import java.util.List;

import javax.ejb.Local;


@Local
public interface DepartmentManager {
	
	Department getDepartmentById(String departmentId);
	
	List<Department> getAllDepartments();
	
	void removeAllDepartments();
	
	void removeDepartment(Department department);
	
	void createDepartment(Department department);

}
