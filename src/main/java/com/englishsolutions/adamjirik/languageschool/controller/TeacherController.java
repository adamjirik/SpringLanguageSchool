package com.englishsolutions.adamjirik.languageschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

	@GetMapping("/")
	public String home() {
		return "teacherindex";
	}
	
	@GetMapping("/assignment/create")
	public String createAssignment() {
		return "createassignment";
	}
	
	@GetMapping("/assignment/grade")
	public String grade() {
		return "gradeassignment";
	}
	
	@GetMapping("/course")
	public String course() {
		return "teachercourse";
	}
}
