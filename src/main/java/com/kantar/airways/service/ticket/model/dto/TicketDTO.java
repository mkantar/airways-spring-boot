package com.kantar.airways.service.ticket.model.dto;

import com.kantar.airways.service.flight.model.dto.FlightDTO;
import com.kantar.airways.service.passenger.model.dto.PassengerDTO;

import java.io.Serializable;

public class TicketDTO implements Serializable {
    private Long id;
    private PassengerDTO passenger;
    private FlightDTO flight;

    public TicketDTO() {
    }

    public TicketDTO(Long id, PassengerDTO passenger, FlightDTO flight) {
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

    public PassengerDTO getPassenger() {
        return passenger;
    }

    public void setPassenger(PassengerDTO passenger) {
        this.passenger = passenger;
    }

    public FlightDTO getFlight() {
        return flight;
    }

    public void setFlight(FlightDTO flight) {
        this.flight = flight;
    }
}
