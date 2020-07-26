package com.kantar.airways.service.airline.model.dto;

import com.kantar.airways.service.flight.model.dto.FlightDTO;

import java.io.Serializable;
import java.util.List;

public class AirlineDTO implements Serializable {
    private Long id;
    private String company;

    public AirlineDTO() {
    }

    public AirlineDTO(Long id, String company) {
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
    
}
