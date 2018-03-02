package com.englishsolutions.adamjirik.languageschool.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Term {
	
	
	

	private long id;
	private String day;
	private int startTime;
	private Set<SchoolGroup> groups = new HashSet<>();
	
	public Term() {
		super();
	}

	public Term(String day, int startTime, Set<SchoolGroup> groups) {
		super();
		this.day = day;
		this.startTime = startTime;
		this.groups = groups;
	}

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            },
            mappedBy="terms")
	public Set<SchoolGroup> getGroups() {
		return groups;
	}

	public void setGroups(Set<SchoolGroup> groups) {
		this.groups = groups;
	}

	public String getDay() {
		return day;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	
}
