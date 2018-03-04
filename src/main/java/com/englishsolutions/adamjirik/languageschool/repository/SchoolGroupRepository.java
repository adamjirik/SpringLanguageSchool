package com.englishsolutions.adamjirik.languageschool.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.englishsolutions.adamjirik.languageschool.model.SchoolGroup;
import com.englishsolutions.adamjirik.languageschool.model.Student;

@Repository
public interface SchoolGroupRepository extends JpaRepository<SchoolGroup, Long> {

	@Query("SELECT s.students FROM SchoolGroup s WHERE s.id = :id")
	public Set<Student> getStudentsByGroup(@Param("id") long id);
	
}
