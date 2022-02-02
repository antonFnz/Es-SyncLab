package com.cartellacardio.service;

import java.util.List;
import com.cartellacardio.entity.Patient;

public interface PatientService {
	
	public List<Patient> getPatients();
	
	public Patient getPatients(int id);

}
