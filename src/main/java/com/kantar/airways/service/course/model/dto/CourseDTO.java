package com.kantar.airways.service.course.model.dto;

import com.kantar.airways.service.airport.model.dto.AirportDTO;

import java.io.Serializable;

public class CourseDTO implements Serializable {
    private Long id;
    private AirportDTO originAirport;
    private AirportDTO destinationAirport;

    public CourseDTO() {
    }

    public CourseDTO(Long id, AirportDTO originAirport, AirportDTO destinationAirport) {
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

    public AirportDTO getOriginAirport() {
        return originAirport;
    }

    public void setOriginAirport(AirportDTO originAirport) {
        this.originAirport = originAirport;
    }

    public AirportDTO getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(AirportDTO destinationAirport) {
        this.destinationAirport = destinationAirport;
    }
}
