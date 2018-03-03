package com.englishsolutions.adamjirik.languageschool.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.Email;

@Entity
public class User {

	private boolean active;
	
	private String email;

	private long id;

	private String lastName;

	private String name;

	private String password;
	private Role role;
	private Student student;
	private Teacher teacher;
	public User() {
	}
	public User(String email, String name, String lastName, String password,
			boolean active, Role role) {
		super();
		this.email = email;
		this.name = name;
		this.lastName = lastName;
		this.password = password;
		this.active = active;
		this.role = role;
	}
	
	public String getEmail() {
		return email;
	}
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getId() {
		return id;
	}
	
	public String getLastname() {
		return lastName;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}



	@ManyToOne
	@JoinColumn(name="role_id")
	public Role getRole() {
		return role;
	}

	@OneToOne(mappedBy="user")
	public Student getStudent() {
		return student;
	}

	@OneToOne(mappedBy="user")
	public Teacher getTeacher() {
		return teacher;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public void setId(long id) {
		this.id = id;
	}

	public void setLastname(String lastname) {
		this.lastName = lastname;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	public void setStudent(Student student) {
		this.student = student;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}


	
}
