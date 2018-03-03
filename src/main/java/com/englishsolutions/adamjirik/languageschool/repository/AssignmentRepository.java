package com.englishsolutions.adamjirik.languageschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.englishsolutions.adamjirik.languageschool.model.Assignment;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Long> {

}
