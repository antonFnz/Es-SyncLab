package com.cartellacardio.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cartellacardio.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	// get all users
	@Override
	public List<User> getUsers() {
		Session currentSession = sessionFactory.getCurrentSession();
		
		// query
		Query<User> query = currentSession.createQuery("from User order by surname", User.class);
		
		List<User> usersList = query.getResultList();
		
		return usersList;
	}
	
	// get one user by its id
	@Override
	public User getUsers(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		User user = currentSession.get(User.class, id);
		return user;
	}

	@Override
	public void addUser(User user) {
		Session currentSession = sessionFactory.getCurrentSession();
		// important so that hibernate doesn't create a new user when updating!
		currentSession.saveOrUpdate(user);
	}

	@Override
	public void deleteUser(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		// query
		Query query = currentSession.createQuery("delete from User where id=:userId");
		query.setParameter("userId", id);
		
		query.executeUpdate();
	}

	@Override
	public List<User> searchUsers(String name) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		// query
		Query query = null;
		
		if(name != null && name.trim().length() > 0) {
			query = currentSession.createQuery("from User where lower(name) like :theName", User.class);
			query.setParameter("theName", "%" + name.toLowerCase() + "%");
		}
		else {
			//empty search bar, return all users
			query = currentSession.createQuery("from User", User.class);
		}
		
		List<User> usersList = query.getResultList();
		
		return usersList;
	}

}
