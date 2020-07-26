package com.kantar.airways.service.flight.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.kantar.airways.service.airline.model.dto.AirlineDTO;
import com.kantar.airways.service.course.model.dto.CourseDTO;

public class FlightDTO implements Serializable {
	private Long id;
	private Integer totalSeat;
	private Integer availableSeat;
	private BigDecimal fee;
	private LocalDateTime date;
	private AirlineDTO airline;
	private CourseDTO course;

	public FlightDTO() {
	}

	public FlightDTO(Long id, Integer totalSeat, Integer availableSeat, BigDecimal fee, LocalDateTime date,
			AirlineDTO airline, CourseDTO course) {
		this.id = id;
		this.totalSeat = totalSeat;
		this.availableSeat = availableSeat;
		this.fee = fee;
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

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public AirlineDTO getAirline() {
		return airline;
	}

	public void setAirline(AirlineDTO airline) {
		this.airline = airline;
	}

	public CourseDTO getCourse() {
		return course;
	}

	public void setCourse(CourseDTO course) {
		this.course = course;
	}
}
