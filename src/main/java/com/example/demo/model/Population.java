package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="population")
public class Population {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "lat")
	private Float lat;
	
	@Column(name = "lon")
	private Float lon;
	
	@Column(name = "premise_id")
	private String pid;
	
	@Column(name = "postalcode")
	private Integer postalcode;
	
	@Column(name = "total_animal_count")
	private Integer tac;
	
	public Population(){
		
	}
	

	public Population(String address, String city, String name, String state, Float lat, Float lon, String premise_id,
			Integer postalcode, Integer total_animal_count) {
		super();
		this.address = address;
		this.city = city;
		this.name = name;
		this.state = state;
		this.lat = lat;
		this.lon = lon;
		this.pid = premise_id;
		this.postalcode = postalcode;
		this.tac = total_animal_count;
	}





	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Float getLat() {
		return lat;
	}

	public void setLat(Float lat) {
		this.lat = lat;
	}

	public Float getLon() {
		return lon;
	}

	public void setLon(Float lon) {
		this.lon = lon;
	}

	public String getPremise_id() {
		return pid;
	}

	public void setPremise_id(String premise_id) {
		this.pid = premise_id;
	}

	public Integer getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(Integer postalcode) {
		this.postalcode = postalcode;
	}

	public Integer getTotal_animal_count() {
		return tac;
	}

	public void setTotal_animal_count(Integer total_animal_count) {
		this.tac = total_animal_count;
	}
	
	
	
	
}
