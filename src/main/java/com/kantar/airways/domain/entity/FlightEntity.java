package com.kantar.airways.domain.entity;

import sun.security.krb5.internal.Ticket;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Entity
@Table(name = "FLIGHT")
public class FlightEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer totalSeat;

    private Integer availableSeat;

    private LocalDate date;

    @OneToMany(mappedBy = "flight", fetch = FetchType.LAZY)
    private List<TicketEntity> tickets;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airlineId")
    private AirlineEntity airline;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "courseId")
    private CourseEntity course;

    public FlightEntity() {
    }

    public FlightEntity(Long id, AirlineEntity airline, CourseEntity course, Integer totalSeat, Integer availableSeat, LocalDate date) {
        this.id = id;
        this.airline = airline;
        this.course = course;
        this.totalSeat = totalSeat;
        this.availableSeat = availableSeat;
        this.date  = date;
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

    public List<TicketEntity> getTickets() {
        return tickets;
    }

    public void setTickets(List<TicketEntity> tickets) {
        this.tickets = tickets;
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
        return "FlightEntity{" +
                "id=" + id +
                ", airline=" + airline +
                ", course=" + course +
                ", totalSeat=" + totalSeat +
                ", availableSeat=" + availableSeat +
                ", date=" + date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                '}';
    }
}
