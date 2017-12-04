package cz.honzakasik.upol.where2study.users;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import cz.honzakasik.upol.where2study.Constants;


@Stateless
public class UserManagerImpl implements UserManager {

    @PersistenceContext(unitName=Constants.DEFAULT_PERSISTENCE_UNIT_NAME)
	private EntityManager em;

	@Override
	public User findUser(String email, String passwordHash) throws Exception {
		List<User> results = em.createQuery("select u from User u"
				+ "where u.email=:email and u.passwordHash=:passwordHash", User.class)
				.setParameter("email", email)
				.setParameter("passwordHash", passwordHash)
				.getResultList();
		if (results.isEmpty()) {
			return null;
		} else if (results.size() > 1) {
			throw new IllegalStateException("Cannot have more than one user with the same email!");
		} else {
			return results.get(0);
		}
	}

	@Override
	public void removeUser(User user) {
		em.remove(user);
	}

	@Override
	public List<User> getAllUsers() {
		return em.createQuery("select u from User u", User.class).getResultList();
	}

	@Override
	public void saveUser(User user) {
		em.merge(user);
	}

}
