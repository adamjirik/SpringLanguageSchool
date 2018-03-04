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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class SchoolGroup {


	private long id;
	private String groupName;
	private Set<Term> terms = new HashSet<>();
	private Classroom groupClassroom;
	private String language;
	private Teacher teacher;
	private Set<Student> students;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            })
    @JoinTable(name = "group_students",
            joinColumns = { @JoinColumn(name = "group_id") },
            inverseJoinColumns = { @JoinColumn(name = "student_id") })
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	@ManyToOne
	@JoinColumn(name="teacher_id")
	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="classroom_id")
	public Classroom getGroupClassroom() {
		return groupClassroom;
	}

	public void setGroupClassroom(Classroom groupClassroom) {
		this.groupClassroom = groupClassroom;
	}

	public String getLanguage() {
		return language;
	}

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            })
    @JoinTable(name = "group_terms",
            joinColumns = { @JoinColumn(name = "group_id") },
            inverseJoinColumns = { @JoinColumn(name = "term_id") })
	public Set<Term> getTerms() {
		return terms;
	}

	public void setTerms(Set<Term> terms) {
		this.terms = terms;
	}

	public void setLanguage(String language) {
		this.language = language;
	}


	public SchoolGroup() {
		super();
	}

	public SchoolGroup(String groupName, 
//			Set<Term> terms, 
			Classroom groupClassroom, 
			String language 
//			Teacher teacher,
//			Set<Student> students
			) {
		super();
		this.groupName = groupName;
//		this.terms = terms;
		this.groupClassroom = groupClassroom;
		this.language = language;
//		this.teacher = teacher;
//		this.students = students;
	}
	
	
	
}
