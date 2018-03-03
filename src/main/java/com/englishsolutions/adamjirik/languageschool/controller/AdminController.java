package com.englishsolutions.adamjirik.languageschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@GetMapping("/")
	public String users() {
		return "userview";
	}
	
	@GetMapping("/courses")
	public String courses() {
		return "courseview";
	}
	
	@GetMapping("/students")
	public String students() {
		return "studentview";
	}
	
	@GetMapping("/teachers")
	public String teachers() {
		return "teacherview";
	}
	
	@GetMapping("/newcourse")
	public String createCourse() {
		return "createcourse";
	}
}
