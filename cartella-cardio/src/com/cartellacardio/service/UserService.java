package com.cartellacardio.service;

import java.util.List;
import com.cartellacardio.entity.User;

public interface UserService {
	
	public List<User> getUsers();
	
	public User getUsers(int id);

	public void addUser(User user);

	public void deleteUser(int id);

	public List<User> searchUsers(String name);

}
