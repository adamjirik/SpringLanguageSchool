package com.englishsolutions.adamjirik.languageschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

	@GetMapping("/course")
	public String course() {
		return "studentcourse";
	}
	
	@GetMapping("/")
	public String home() {
		return "studentindex";
	}
}
