package com.englishsolutions.adamjirik.languageschool.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.englishsolutions.adamjirik.languageschool.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	
}
