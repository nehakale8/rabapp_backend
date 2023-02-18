package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="movement")
public class Movements {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "company")
	private String company;
	
	@Column(name = "reason")
	private String reason;
	
	@Column(name = "species")
	private String species;
	
	@Column(name = "origin_premise_id")
	private String origin_premise_id;
	
	@Column(name = "dest_premise_id")
	private String dest_premise_id;
	
	@Column(name = "start_date")
	private String start_date;
	
	@Column(name = "moved_count")
	private Integer moved_count;
	
	public Movements(){
		
	}
	
	
	public Movements(String company, String reason, String species, String origin_premise_id, String dest_premise_id,
			String start_date, Integer moved_count) {
		super();
		this.company = company;
		this.reason = reason;
		this.species = species;
		this.origin_premise_id = origin_premise_id;
		this.dest_premise_id = dest_premise_id;
		this.start_date = start_date;
		this.moved_count = moved_count;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public String getOrigin_premise_id() {
		return origin_premise_id;
	}
	public void setOrigin_premise_id(String origin_premise_id) {
		this.origin_premise_id = origin_premise_id;
	}
	public String getDest_premise_id() {
		return dest_premise_id;
	}
	public void setDest_premise_id(String dest_premise_id) {
		this.dest_premise_id = dest_premise_id;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public Integer getMoved_count() {
		return moved_count;
	}
	public void setMoved_count(Integer moved_count) {
		this.moved_count = moved_count;
	}
}
