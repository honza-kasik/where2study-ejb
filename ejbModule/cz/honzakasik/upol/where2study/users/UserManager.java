package cz.honzakasik.upol.where2study.users;

import java.util.List;

import javax.ejb.Local;

@Local
public interface UserManager {
	
	/**
	 * Find persisted user in database
	 * @param email user's email
	 * @param passwordHash password hash
	 * @return user if user which has both email and password hash with same value
	 * @throws Exception
	 */
	User findUser(String email, String passwordHash) throws Exception;
	
	/**
	 * Find persisted user in database
	 */
	User findUser(int id);	
	
	/**
	 * Remove user persisted in database
	 * @param user user to remove
	 */
	void removeUser(User user);
	
	/**
	 * Get all users persisted in database
	 * @return List of all users
	 */
	List<User> getAllUsers();

	/**
	 * Save user to database
	 * @param user
	 */
	void saveUser(User user);
	
	/**
	 * Persist user in database
	 * @param user
	 */
	void createUser(User user);
}
