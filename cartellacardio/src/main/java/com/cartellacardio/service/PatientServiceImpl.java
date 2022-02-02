package com.cartellacardio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cartellacardio.dao.PatientDAO;
import com.cartellacardio.entity.Patient;

@Service
public class PatientServiceImpl implements PatientService {
	
	@Autowired
	private PatientDAO patientDAO;
	
	@Override
	@Transactional
	public List<Patient> getPatients() {
		return patientDAO.getPatients();
	}
	
	@Override
	@Transactional
	public Patient getPatients(int id) {
		return patientDAO.getPatients(id);
	}

}
