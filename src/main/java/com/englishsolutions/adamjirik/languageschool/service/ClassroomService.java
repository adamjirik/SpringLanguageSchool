package com.englishsolutions.adamjirik.languageschool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.englishsolutions.adamjirik.languageschool.model.Classroom;
import com.englishsolutions.adamjirik.languageschool.repository.ClassroomRepository;

@Service
public class ClassroomService {

	@Autowired
	public ClassroomService(ClassroomRepository classroomRepo) {
		super();
		this.classroomRepo = classroomRepo;
	}

	private ClassroomRepository classroomRepo;
	
	public List<Classroom> getAll() {
		
		return classroomRepo.findAll();
	}
	
	
}
