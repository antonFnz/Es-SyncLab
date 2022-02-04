package com.cartellacardio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cartellacardio.entity.Cartella;
import com.cartellacardio.entity.Patient;
import com.cartellacardio.service.PatientService;
import com.cartellacardio.service.RecordService;

@Controller
@RequestMapping("/medic")
public class MedicController {
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private RecordService recordService;
	
	@GetMapping("/list")
	public String listPatients(Model model) {
		List<Patient> patients = patientService.getPatients();
		model.addAttribute("patients", patients);
		return "list-patients";
	}
	
	@GetMapping("/showPatientRecords")
	public String showPatientRecords(@RequestParam("patientId") int id, Model model) {
		Patient patient = patientService.getPatients(id);
		int idUser = patient.getUser().getId();
		List<Cartella> cartella = recordService.getRecords(idUser);
		model.addAttribute("records", cartella);
		return "cartella-view";
	}
	
	@GetMapping("/showFormUpdate")
	public String showFormUpdate(@RequestParam("patientId") int id, Model model) {
		Patient patient = patientService.getPatients(id);
		int idUser = patient.getUser().getId();
		List<Cartella> cartella = recordService.getRecords(idUser);
		Cartella record = cartella.get(0);
		model.addAttribute("records", record);
		return "record-form";
	}
	
	@PostMapping("/addRecord")
	public String saveRecord(@ModelAttribute("records") Cartella cartella) {
		recordService.saveRecord(cartella);
		return "redirect:/medic/showPatientRecords";
	}

}
