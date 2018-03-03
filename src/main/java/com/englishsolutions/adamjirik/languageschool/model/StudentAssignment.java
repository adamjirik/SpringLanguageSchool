package com.englishsolutions.adamjirik.languageschool.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="student_assignment")
public class StudentAssignment implements Serializable{

	private Assignment assignment;
	
	private Double grade;
	private Student student;
	public StudentAssignment() {
		super();
	}
	public StudentAssignment(Double grade) {
		super();
		this.grade = grade;
	}
	
	public StudentAssignment(Student student, Assignment assignment, Double grade) {
		super();
		this.student = student;
		this.assignment = assignment;
		this.grade = grade;
	}
	

	
	@Id
	@ManyToOne
	@JoinColumn(name="assignment_id")
	public Assignment getAssignment() {
		return assignment;
	}
	@Column(name="grade")
	public Double getGrade() {
		return grade;
	}

	@Id
	@ManyToOne
	@JoinColumn(name="student_id")
	public Student getStudent() {
		return student;
	}
	
	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}
	public void setGrade(Double grade) {
		this.grade = grade;
	}
	
	public void setStudent(Student student) {
		this.student = student;
	}
	

	
	
}
