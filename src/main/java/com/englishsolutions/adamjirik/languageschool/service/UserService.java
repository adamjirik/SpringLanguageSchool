package com.englishsolutions.adamjirik.languageschool.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.englishsolutions.adamjirik.languageschool.model.Role;
import com.englishsolutions.adamjirik.languageschool.model.User;
import com.englishsolutions.adamjirik.languageschool.repository.RoleRepository;
import com.englishsolutions.adamjirik.languageschool.repository.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	private RoleRepository roleRepository;
	@Autowired
	public UserService(RoleRepository roleRepository, UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		super();
		this.roleRepository = roleRepository;
		this.userRepository = userRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	
	public Page<User> getAll(Pageable pageable){
		return userRepository.findAll(pageable);
	}

	public User getUserById(long id) {
		return userRepository.findOne(id);
	}
	
	public void delete (long id) {
		userRepository.delete(id);
	}
	
	private Role getUserRole() {
		Role role = roleRepository.findByRole("User");
		if(Objects.isNull(role)) {
			role = roleRepository.save(new Role("User"));
		}
		return role;
	}
	
	public User addUserWithRoleUser(User user) {
		
		user.setActive(true);
		
		Role role = getUserRole();
		
		user.setRole(role);
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		
		return userRepository.save(user);
	}
	
}
