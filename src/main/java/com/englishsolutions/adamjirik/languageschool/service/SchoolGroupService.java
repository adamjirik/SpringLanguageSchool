package com.englishsolutions.adamjirik.languageschool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.englishsolutions.adamjirik.languageschool.model.SchoolGroup;
import com.englishsolutions.adamjirik.languageschool.repository.SchoolGroupRepository;

@Service
public class SchoolGroupService {

	private SchoolGroupRepository sgRepo;
	@Autowired
	public SchoolGroupService(SchoolGroupRepository sgRepo) {
		this.sgRepo = sgRepo;
	}

	public SchoolGroup save(SchoolGroup schoolGroup) {
		return sgRepo.save(schoolGroup);
	}
	
	public Page<SchoolGroup> getAll(Pageable pageable){
		return sgRepo.findAll(pageable);
	}
}
