package com.cartellacardio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cartellacardio.dao.UserDAO;
import com.cartellacardio.entity.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;

	// get all users
	@Override
	@Transactional
	public List<User> getUsers() {
		return userDAO.getUsers();
	}
	
	//get one user by its id
	@Override
	@Transactional
	public User getUsers(int id) {
		return userDAO.getUsers(id);
	}
	
	//get one user by its username
		@Override
		@Transactional
		public User getUsers(String username) {
			return userDAO.getUsers(username);
		}

	@Override
	@Transactional
	public void addUser(User user) {
		userDAO.addUser(user);
	}

	@Override
	@Transactional
	public void deleteUser(int id) {
		userDAO.deleteUser(id);
	}

	@Override
	@Transactional
	public List<User> searchUsers(String name) {
		return userDAO.searchUsers(name);
	}

}
