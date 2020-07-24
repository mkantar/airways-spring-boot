package com.kantar.airways.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "TICKET")
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "passengerId", nullable = false)
    private PassengerEntity passenger;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flightId")
    private FlightEntity flight;

    public TicketEntity() {
    }

    public TicketEntity(Long id, PassengerEntity passenger, FlightEntity flight) {
        this.id = id;
        this.passenger = passenger;
        this.flight = flight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PassengerEntity getPassenger() {
        return passenger;
    }

    public void setPassenger(PassengerEntity passenger) {
        this.passenger = passenger;
    }

    public FlightEntity getFlight() {
        return flight;
    }

    public void setFlight(FlightEntity flight) {
        this.flight = flight;
    }

    @Override
    public String toString() {
        return "TicketEntity{" +
                "id=" + id +
                ", passenger=" + passenger.getId() +
                ", flight=" + flight.getId() +
                '}';
    }
}
