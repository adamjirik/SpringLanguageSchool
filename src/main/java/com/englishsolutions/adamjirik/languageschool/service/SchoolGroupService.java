package com.englishsolutions.adamjirik.languageschool.service;

import org.springframework.stereotype.Service;

import com.englishsolutions.adamjirik.languageschool.model.SchoolGroup;
import com.englishsolutions.adamjirik.languageschool.repository.SchoolGroupRepository;

@Service
public class SchoolGroupService {

	private SchoolGroupRepository sgRepo;
	
	public SchoolGroup save(SchoolGroup schoolGroup) {
		return sgRepo.save(schoolGroup);
	}
	
}
