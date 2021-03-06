package com.kantar.airways.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "AIRPORT")
public class AirportEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String name;

	private String city;

	public AirportEntity() {
	}

	public AirportEntity(Long id, String name, String city) {
		this.id = id;
		this.name = name;
		this.city = city;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "AirportEntity{" + "id=" + id + ", name='" + name + '\'' + ", city='" + city + '\'' + '}';
	}
}
