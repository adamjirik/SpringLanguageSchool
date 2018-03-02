package com.englishsolutions.adamjirik.languageschool.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Classroom {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String roomName;
	private Integer seats;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public Integer getSeats() {
		return seats;
	}
	public void setSeats(Integer seats) {
		this.seats = seats;
	}
	public Classroom(String roomName, Integer seats) {
		super();
		this.roomName = roomName;
		this.seats = seats;
	}
	public Classroom() {
		super();
	}
	
	
}
