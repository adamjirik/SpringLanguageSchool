package com.englishsolutions.adamjirik.languageschool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.englishsolutions.adamjirik.languageschool.model.User;
import com.englishsolutions.adamjirik.languageschool.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	private UserService userService;
	
	@Autowired
	public AdminController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/")
	public String users(Model model, Pageable pageable) {
		Page<User> pageUser = userService.getAll(pageable);
		model.addAttribute("users", pageUser);
		PageWrapper<User> page = new PageWrapper<>(pageUser, "/admin/config/");
		model.addAttribute("page", page);
		
		return "admin/userview";
	}
	
	@GetMapping("/courses")
	public String courses() {
		return "admin/courseview";
	}
	
	@GetMapping("/students")
	public String students() {
		return "admin/studentview";
	}
	
	@GetMapping("/teachers")
	public String teachers() {
		return "admin/teacherview";
	}
	
	@GetMapping("/newcourse")
	public String createCourse() {
		return "admin/createcourse";
	}
}
