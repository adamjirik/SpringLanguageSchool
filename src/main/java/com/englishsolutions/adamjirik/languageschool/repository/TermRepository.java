package com.englishsolutions.adamjirik.languageschool.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.englishsolutions.adamjirik.languageschool.model.Term;

@Repository
public interface TermRepository extends JpaRepository<Term, Long> {

	@Query("SELECT s.terms FROM SchoolGroup s WHERE s.id = :id")
	public Set<Term> findTermsByGroup(@Param("id") long id);
	
}
