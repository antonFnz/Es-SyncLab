package com.cartellacardio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cartellacardio.entity.Patient;
import com.cartellacardio.service.PatientService;

@Controller
@RequestMapping("/medic")
public class MedicController {
	
	@Autowired
	private PatientService patientService;
	
	@GetMapping("/list")
	public String listPatients(Model model) {
		List<Patient> patients = patientService.getPatients();
		model.addAttribute("patients", patients);
		return "list-patients";
	}

}
