package com.englishsolutions.adamjirik.languageschool.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Teacher {


	private long id;
	private String firstName;
	private String lastName;
	private Set<SchoolGroup> groups = new HashSet<>();
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	private User user;
	
	@OneToMany(mappedBy="teacher")
	public Set<SchoolGroup> getGroups() {
		return groups;
	}

	public void setGroups(Set<SchoolGroup> groups) {
		this.groups = groups;
	}


	public Teacher(String firstName, String lastName, Set<SchoolGroup> groups, User user) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.groups = groups;
		this.user = user;
	}

	public Teacher() {
		super();
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
