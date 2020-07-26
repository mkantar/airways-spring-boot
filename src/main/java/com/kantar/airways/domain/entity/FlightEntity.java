package com.kantar.airways.domain.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "FLIGHT")
public class FlightEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Integer totalSeat;

	private Integer availableSeat;

	private BigDecimal fee;

	private Float factor;

	private LocalDateTime date;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "airlineId")
	private AirlineEntity airline;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "courseId")
	private CourseEntity course;

	public FlightEntity() {
	}

	public FlightEntity(Long id, Integer totalSeat, Integer availableSeat, BigDecimal fee, Float factor,
						LocalDateTime date, AirlineEntity airline, CourseEntity course) {
		this.id = id;
		this.totalSeat = totalSeat;
		this.availableSeat = availableSeat;
		this.fee = fee;
		this.factor = factor;
		this.date = date;
		this.airline = airline;
		this.course = course;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getTotalSeat() {
		return totalSeat;
	}

	public void setTotalSeat(Integer totalSeat) {
		this.totalSeat = totalSeat;
	}

	public Integer getAvailableSeat() {
		return availableSeat;
	}

	public void setAvailableSeat(Integer availableSeat) {
		this.availableSeat = availableSeat;
	}

	public BigDecimal getFee() {
		return fee;
	}

	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}

	public Float getFactor() {
		return factor;
	}

	public void setFactor(Float factor) {
		this.factor = factor;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public AirlineEntity getAirline() {
		return airline;
	}

	public void setAirline(AirlineEntity airline) {
		this.airline = airline;
	}

	public CourseEntity getCourse() {
		return course;
	}

	public void setCourse(CourseEntity course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "FlightEntity{" + "id=" + id + ", airline=" + airline + ", course=" + course + ", totalSeat=" + totalSeat
				+ ", availableSeat=" + availableSeat + ", date="
				+ date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) + '}';
	}
}
