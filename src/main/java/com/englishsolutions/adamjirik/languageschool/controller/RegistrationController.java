package com.englishsolutions.adamjirik.languageschool.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.englishsolutions.adamjirik.languageschool.model.User;
import com.englishsolutions.adamjirik.languageschool.service.UserService;

@Controller
public class RegistrationController {

	private UserService userService;
	
	@Autowired
	public RegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping("/register")
	public String register(Model model) {
		
		model.addAttribute("user", new User());
		return "register";
	}
	
	@PostMapping("/register")
	public String save(@Valid @ModelAttribute User user, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "register";
		}
		User savedUser = userService.addUserWithRoleUser(user);
		System.out.println("SavedUser: " + savedUser);
		
		model.addAttribute("success", "User has been registred successsfully");
		model.addAttribute("user", new User());
		
		return "register";
	}
}
