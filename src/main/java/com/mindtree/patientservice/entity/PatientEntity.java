package com.mindtree.patientservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="patient")
public class PatientEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="visited_doctor")
	private int visitedDoctor;
	
	@Column(name="date")
	private String dateOfVisit;
	
	public PatientEntity(int id, String name, int visitedDoctor, String dateOfVisit) {
		super();
		this.id = id;
		this.name = name;
		this.visitedDoctor = visitedDoctor;
		this.dateOfVisit = dateOfVisit;
	}
	public PatientEntity() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getVisitedDoctor() {
		return visitedDoctor;
	}
	public void setVisitedDoctor(int visitedDoctor) {
		this.visitedDoctor = visitedDoctor;
	}
	public String getDateOfVisit() {
		return dateOfVisit;
	}
	public void setDateOfVisit(String dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}
	@Override
	public String toString() {
		return "PatientEntity [id=" + id + ", name=" + name + ", visitedDoctor=" + visitedDoctor + ", dateOfVisit="
				+ dateOfVisit + "]";
	}
	
	
	

}
