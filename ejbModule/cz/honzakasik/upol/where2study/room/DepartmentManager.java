package cz.honzakasik.upol.where2study.room;

import java.util.List;

import javax.ejb.Local;

/**
 * Interface for accessing persisted department entities
 */
@Local
public interface DepartmentManager {
	
	/**
	 * Get department by ID - abbreviation
	 * @param departmentId abbreviation of department - e.g. KMI for department of computer science
	 * @return found department or null
	 */
	Department getDepartmentById(String departmentId);
	
	/**
	 * Get all departments in database
	 * @return all departments
	 */
	List<Department> getAllDepartments();
	
	/**
	 * Remove all departments from database
	 */
	void removeAllDepartments();
	
	/**
	 * Remove department
	 * @param department department to remove
	 */
	void removeDepartment(Department department);
	
	/**
	 * Persist department
	 * @param department department to persist
	 */
	void createDepartment(Department department);

}
