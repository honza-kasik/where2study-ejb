package cz.honzakasik.upol.where2study.room;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import cz.honzakasik.upol.where2study.Constants;

@Stateless
public class DepartmentManagerImpl implements DepartmentManager {
	
	@PersistenceContext(unitName=Constants.DEFAULT_PERSISTENCE_UNIT_NAME)
	private EntityManager em;

	@Override
	public Department getDepartmentById(String departmentId) {
		return em.find(Department.class, departmentId);
	}

	@Override
	public List<Department> getAllDepartments() {
		return em.createQuery("select d from Department d", Department.class).getResultList();
	}

	@Override
	public void removeAllDepartments() {
		em.createQuery("delete from Department d", Department.class).executeUpdate();
	}

	@Override
	public void removeDepartment(Department department) {
		em.remove(department);
		
	}

	@Override
	public void createDepartment(Department department) {
		em.persist(department);
	}

}
