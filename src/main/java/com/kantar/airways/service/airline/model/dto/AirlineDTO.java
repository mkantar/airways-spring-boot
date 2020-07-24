package com.kantar.airways.service.airline.model.dto;

import com.kantar.airways.service.flight.model.dto.FlightDTO;

import java.io.Serializable;
import java.util.List;

public class AirlineDTO implements Serializable {
    private Long id;
    private String company;
    private List<FlightDTO> flights;

    public AirlineDTO() {
    }

    public AirlineDTO(Long id, String company, List<FlightDTO> flights) {
        this.id = id;
        this.company = company;
        this.flights = flights;
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

    public List<FlightDTO> getFlights() {
        return flights;
    }

    public void setFlights(List<FlightDTO> flights) {
        this.flights = flights;
    }
}
