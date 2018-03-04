package com.englishsolutions.adamjirik.languageschool.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.englishsolutions.adamjirik.languageschool.model.Classroom;
import com.englishsolutions.adamjirik.languageschool.model.SchoolGroup;
import com.englishsolutions.adamjirik.languageschool.model.User;
import com.englishsolutions.adamjirik.languageschool.service.ClassroomService;
import com.englishsolutions.adamjirik.languageschool.service.SchoolGroupService;
import com.englishsolutions.adamjirik.languageschool.service.TermService;
import com.englishsolutions.adamjirik.languageschool.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	private UserService userService;
	private SchoolGroupService sgService;
	private TermService termService;
	private ClassroomService classService;

	@Autowired
	public AdminController(UserService userService, SchoolGroupService sgService, TermService termService, ClassroomService classService) {
		this.userService = userService;
		this.sgService = sgService;
		this.termService = termService;
		this.classService = classService;
	}
	
	@GetMapping("/")
	public String users(Model model, Pageable pageable) {
		Page<User> pageUser = userService.getAll(pageable);
		model.addAttribute("users", pageUser);
		PageWrapper<User> page = new PageWrapper<>(pageUser, "/admin/");
		model.addAttribute("page", page);
		
		return "admin/userview";
	}
	
	@GetMapping("/courses")
	public String courses(Model model, Pageable pageable) {
		Page<SchoolGroup> pageGroup = sgService.getAll(pageable);
		model.addAttribute("groups", pageGroup);
		PageWrapper<SchoolGroup> page = new PageWrapper<>(pageGroup, "/admin/courses");
		model.addAttribute("page", page);
		
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
	
	@GetMapping("/createcourse")
	public String createCourse(Model model) {
//		List<Term> all = termService.getAll();
//		Set<Term> allTerms = new HashSet<>();
//		allTerms.addAll(all);
//		model.addAttribute("terms", allTerms);
		List<Classroom> allClass = classService.getAll();
		
		Set<Classroom> classSet = new HashSet<>();
		classSet.addAll(allClass);
		model.addAttribute("rooms", classSet);
		for(Classroom room : classSet) {
			System.out.println(room);
		}
		model.addAttribute("schoolGroup", new SchoolGroup());
		
		return "admin/createcourse";
		
	}
	@PostMapping("/createcourse")
	public String createCourse(@Valid @ModelAttribute SchoolGroup schoolGroup, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			System.out.println("error");
			System.out.println(bindingResult.getFieldError().toString());
			return "admin/createcourse";
		}
		List<Classroom> allClass = classService.getAll();
		Set<Classroom> classSet = new HashSet<>();
		classSet.addAll(allClass);
		SchoolGroup savedGroup = sgService.save(schoolGroup);
		System.out.println(savedGroup);
		model.addAttribute("success", "Group has been saved");
		model.addAttribute("schoolGroup", new SchoolGroup());
		model.addAttribute("rooms", classSet);
		return "admin/createcourse";
	}
}
