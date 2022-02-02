package com.cartellacardio.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cartellacardio.entity.Cartella;

@Repository
public class RecordDAOImpl implements RecordDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Cartella> getRecords(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Cartella> query = currentSession.createQuery("from Cartella as c where c.patient.user.id=:userId", Cartella.class);
		query.setParameter("userId", id);
		List<Cartella> record = query.getResultList();
		return record;
	}

}
