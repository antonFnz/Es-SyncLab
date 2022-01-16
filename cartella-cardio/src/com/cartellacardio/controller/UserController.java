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

import com.cartellacardio.entity.User;
import com.cartellacardio.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/list")
	public String listUsers(Model model) {
		List<User> usersList = userService.getUsers();
		model.addAttribute("users", usersList);
		return "list-users";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "user-form";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("userId") int id, Model model) {
		User user = userService.getUsers(id);
		model.addAttribute("user", user);
		return "user-form";
	}
	
	@PostMapping("/addUser")
	public String saveUser(@ModelAttribute("user") User user) {
		userService.addUser(user);
		return "redirect:/user/list";
	}
	
	@GetMapping("/delete")
	public String deleteUser(@RequestParam("userId") int id) {
		userService.deleteUser(id);
		return "redirect:/user/list";
	}
	
	@GetMapping("/search")
	public String searchUsers(@RequestParam("searchName") String name, Model model) {
		List<User> users = userService.searchUsers(name);
		model.addAttribute("users", users);
		return "list-users";
	}

}
