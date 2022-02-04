package com.cartellacardio.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cartellacardio.entity.Patient;

@Repository
public class PatientDAOImpl implements PatientDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	// get all patients
	@Override
	public List<Patient> getPatients() {
		Session currentSession = sessionFactory.getCurrentSession();
		
		// query
		Query<Patient> query = currentSession.createQuery("from Patient", Patient.class);
		
		List<Patient> patientList = query.getResultList();
		
		return patientList;
	}
	
	// get one patient by its id
	@Override
	public Patient getPatients(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Patient patient = currentSession.get(Patient.class, id);
		return patient;
	}

}
