package com.englishsolutions.adamjirik.languageschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.englishsolutions.adamjirik.languageschool.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByRole(String role);

}
