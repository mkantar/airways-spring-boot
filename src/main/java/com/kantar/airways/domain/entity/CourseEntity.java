package com.kantar.airways.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "COURSE", uniqueConstraints = {@UniqueConstraint(columnNames = {"originId", "destinationId"})})
public class CourseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "originId", nullable = false)
	private AirportEntity originAirport;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "destinationId", nullable = false)
	private AirportEntity destinationAirport;

	public CourseEntity() {
	}

	public CourseEntity(Long id, AirportEntity originAirport, AirportEntity destinationAirport) {
		this.id = id;
		this.originAirport = originAirport;
		this.destinationAirport = destinationAirport;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AirportEntity getOriginAirport() {
		return originAirport;
	}

	public void setOriginAirport(AirportEntity originAirport) {
		this.originAirport = originAirport;
	}

	public AirportEntity getDestinationAirport() {
		return destinationAirport;
	}

	public void setDestinationAirport(AirportEntity destinationAirport) {
		this.destinationAirport = destinationAirport;
	}

	@Override
	public String toString() {
		return "CourseEntity{" + "id=" + id + ", originAirport=" + originAirport.getName() + ", destinationAirport="
				+ destinationAirport.getName() + '}';
	}
}
