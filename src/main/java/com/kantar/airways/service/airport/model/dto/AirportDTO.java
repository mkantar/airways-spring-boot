package com.kantar.airways.service.airport.model.dto;

import com.kantar.airways.service.course.model.dto.CourseDTO;

import java.io.Serializable;
import java.util.List;

public class AirportDTO implements Serializable {
    private Long id;
    private String name;
    private String city;

    public AirportDTO() {
    }

    public AirportDTO(Long id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
