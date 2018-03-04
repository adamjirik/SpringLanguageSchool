package com.englishsolutions.adamjirik.languageschool.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.englishsolutions.adamjirik.languageschool.model.Term;
import com.englishsolutions.adamjirik.languageschool.repository.TermRepository;

@Service
public class TermService {

	@Autowired
	public TermService(TermRepository termRepo) {
		this.termRepo = termRepo;
	}

	private TermRepository termRepo;
	
	public Set<Term> getTermsByGroup(long id){
		return termRepo.findTermsByGroup(id);
	}
	
	public List<Term> getAll(){
		return termRepo.findAll();
	}
	
}
