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

	private Teacher teacher;
	
	@OneToOne(mappedBy="user")
	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@OneToOne(mappedBy="user")
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	private Student student;

	private long id;
	
	@Column(unique=true)
	@Email
	private String email;
	
	private String password;
	
	private boolean active;
	

	private Role role;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User() {
		super();
	}

	public User(String email, String password, boolean active, Role role) {
		super();
		this.email = email;
		this.password = password;
		this.active = active;
		this.role = role;
	}

	public User(Integer id, String email, String password, boolean active, Role role) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.active = active;
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	@ManyToOne
	@JoinColumn(name="role_id")
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}


	
}
