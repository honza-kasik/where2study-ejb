package cz.honzakasik.upol.where2study.users;

import java.util.List;

import javax.ejb.Local;

@Local
public interface UserManager {
	
	User findUser(String username, String password) throws Exception;	
	
	void removeUser(User user);
			
	List<User> getAllUsers();

}
