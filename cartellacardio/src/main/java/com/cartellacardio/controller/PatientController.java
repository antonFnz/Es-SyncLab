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
import com.cartellacardio.entity.User;
import com.cartellacardio.service.RecordService;
import com.cartellacardio.service.UserService;

@Controller
@RequestMapping("/patient")
public class PatientController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RecordService recordService;
	
	@GetMapping("/personal")
	public String showPersonal(@RequestParam("userName") String username, Model model) {
		User user = userService.getUsers(username);
		List<Cartella> cartella = recordService.getRecords(user.getId());
		model.addAttribute("records", cartella);
		double risk = cartella.get(0).calcRisk();
		model.addAttribute("risk", risk);
		return "cartella-view";
	}
	
	@GetMapping("/addNote")
	public String showUpdate(@RequestParam("userId") int id, Model model){
		List<Cartella> cartella = recordService.getRecords(id);
		Cartella record = cartella.get(0);
		model.addAttribute("records", record);
		return "record-form";
	}
	
	@PostMapping("/save")
	public String saveRecord(@ModelAttribute("records") Cartella cartella) {
		recordService.saveRecordPatient(cartella);
		return "redirect:/";
	}

}
