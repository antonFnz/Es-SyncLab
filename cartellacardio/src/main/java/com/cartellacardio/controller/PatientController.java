package com.cartellacardio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cartellacardio.entity.Cartella;
import com.cartellacardio.service.RecordService;

@Controller
@RequestMapping("/patient")
public class PatientController {
	
	@Autowired
	private RecordService recordService;
	
	@GetMapping("/personal")
	public String showPersonal(@RequestParam("userId") int id, Model model) {
		List<Cartella> cartella = recordService.getRecords(id);
		model.addAttribute("records", cartella);
		return "cartella-view";
	}

}
