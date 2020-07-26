package com.kantar.airways.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "AIRLINE")
public class AirlineEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String company;

	public AirlineEntity() {
	}

	public AirlineEntity(Long id, String company) {
		this.id = id;
		this.company = company;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "AirlineEntity{" + "id=" + id + ", company='" + company + '\'' + '}';
	}
}
