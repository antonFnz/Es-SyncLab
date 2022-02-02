package com.cartellacardio.dao;

import java.util.List;

import com.cartellacardio.entity.Patient;

public interface PatientDAO {
	
	public List<Patient> getPatients();
	
	public Patient getPatients(int id);

}
