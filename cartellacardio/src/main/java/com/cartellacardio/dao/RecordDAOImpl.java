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

	@Override
	public void saveRecord(Cartella cartella) {
		Session currentSession = sessionFactory.getCurrentSession();
		// important so that hibernate doesn't create a new user when updating!
		Cartella update = (Cartella) currentSession.get(Cartella.class, cartella.getIdcartella());
		update.setIdcartella(cartella.getIdcartella());
		update.setMotive(cartella.getMotive());
		update.setAnamnesis(cartella.getAnamnesis());
		update.setPressure(cartella.getPressure());
		update.setHeartRate(cartella.getHeartRate());
		update.setWaist(cartella.getWaist());
		update.setMedicNote(cartella.getMedicNote());
	}
	
	@Override
	public void saveRecordPatient(Cartella cartella) {
		Session currentSession = sessionFactory.getCurrentSession();
		// important so that hibernate doesn't create a new user when updating!
		Cartella update = (Cartella) currentSession.get(Cartella.class, cartella.getIdcartella());
		update.setPatientNote(cartella.getPatientNote());
	}

}
