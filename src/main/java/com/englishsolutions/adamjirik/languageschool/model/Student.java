package com.englishsolutions.adamjirik.languageschool.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Student {
	
	private Set<SchoolGroup> groups = new HashSet<>();
	

	private long id;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
	
	
	private String lastName;
	
	private String name;
	
	private Set<StudentAssignment> studentAssignments;

	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
	public Set<StudentAssignment> getAssignments() {
		return studentAssignments;
	}

	@ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            },
            mappedBy="students")
	public Set<SchoolGroup> getGroups() {
		return groups;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public String getLastName() {
		return lastName;
	}

	public String getName() {
		return name;
	}
	
	public void setAssignments(Set<StudentAssignment> assignments) {
		this.studentAssignments = assignments;
	}

	public void setGroups(Set<SchoolGroup> groups) {
		this.groups = groups;
	}
	
	
	public void setId(long id) {
		this.id = id;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setName(String name) {
		this.name = name;
	}



	public Student(Set<SchoolGroup> groups, User user, String lastName, String name,
			Set<StudentAssignment> studentAssignments) {
		super();
		this.groups = groups;
		this.user = user;
		this.lastName = lastName;
		this.name = name;
		studentAssignments = new HashSet<>();
	}

	public Student() {
		super();
	}


	
	


	 


}
