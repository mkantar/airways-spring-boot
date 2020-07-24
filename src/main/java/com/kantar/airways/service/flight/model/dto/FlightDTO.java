package com.kantar.airways.service.flight.model.dto;

import com.kantar.airways.service.airline.model.dto.AirlineDTO;
import com.kantar.airways.service.course.model.dto.CourseDTO;
import com.kantar.airways.service.ticket.model.dto.TicketDTO;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class FlightDTO implements Serializable {
    private Long id;
    private Integer totalSeat;
    private Integer availableSeat;
    private LocalDate date;
    private List<TicketDTO> tickets;
    private AirlineDTO airline;
    private CourseDTO course;

    public FlightDTO() {
    }

    public FlightDTO(Long id, Integer totalSeat, Integer availableSeat, LocalDate date, List<TicketDTO> tickets, AirlineDTO airline, CourseDTO course) {
        this.id = id;
        this.totalSeat = totalSeat;
        this.availableSeat = availableSeat;
        this.date = date;
        this.tickets = tickets;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<TicketDTO> getTickets() {
        return tickets;
    }

    public void setTickets(List<TicketDTO> tickets) {
        this.tickets = tickets;
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
