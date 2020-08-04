package org.spring5samples.DAOs;

import java.util.List;
import org.spring5samples.models.*;


public interface ISecurityDAO {

	public List<User> getAllUsers();
	
	public void addUser(User user);
	
}
