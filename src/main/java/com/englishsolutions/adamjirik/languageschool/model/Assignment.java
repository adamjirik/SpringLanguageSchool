package com.englishsolutions.adamjirik.languageschool.model;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Assignment {


	private long id;
	private String description;
	private Date dueDate;
	private Double grade;
	private Set<StudentAssignment> studentAssignments;
	private SchoolGroup schoolGroup;

	@ManyToOne
	@JoinColumn(name="group_id")
	public SchoolGroup getSchoolGroup() {
		return schoolGroup;
	}



	public void setSchoolGroup(SchoolGroup schoolGroup) {
		this.schoolGroup = schoolGroup;
	}

	private String type;

	public Assignment() {
		super();
	}



	public Assignment(String description, Date dueDate, Double grade, 
			String type) {
		super();
		this.description = description;
		this.dueDate = dueDate;
		this.grade = grade;
		this.type = type;
	}



	public String getDescription() {
		return description;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public Double getGrade() {
		return grade;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	@OneToMany(mappedBy = "assignment")
	public Set<StudentAssignment> getStudentAssignments() {
		return studentAssignments;
	}

	public String getType() {
		return type;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public void setGrade(Double grade) {
		this.grade = grade;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setStudentAssignments(Set<StudentAssignment> studentAssignments) {
		this.studentAssignments = studentAssignments;
	}

	public void setType(String type) {
		this.type = type;
	}

}
