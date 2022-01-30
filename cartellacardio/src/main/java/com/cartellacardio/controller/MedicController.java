package com.cartellacardio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cartellacardio.service.UserService;

@Controller
@RequestMapping("/medic")
public class MedicController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/list")
	public String listPatients() {
		return "list-patients";
	}

}
