package com.cartellacardio.dao;

import java.util.List;

import com.cartellacardio.entity.User;

public interface UserDAO {
	
	public List<User> getUsers();
	
	public User getUsers(int id);
	
	public User getUsers(String username);

	public void addUser(User user);

	public void deleteUser(int id);

	public List<User> searchUsers(String name);

}
