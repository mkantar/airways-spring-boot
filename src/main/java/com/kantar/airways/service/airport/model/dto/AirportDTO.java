package com.kantar.airways.service.airport.model.dto;

import com.kantar.airways.service.course.model.dto.CourseDTO;

import java.io.Serializable;
import java.util.List;

public class AirportDTO implements Serializable {
    private Long id;
    private String name;
    private String city;
    private List<CourseDTO> originCourses;
    private List<CourseDTO> destinationCourses;

    public AirportDTO() {
    }

    public AirportDTO(Long id, String name, String city, List<CourseDTO> originCourses, List<CourseDTO> destinationCourses) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.originCourses = originCourses;
        this.destinationCourses = destinationCourses;
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

    public List<CourseDTO> getOriginCourses() {
        return originCourses;
    }

    public void setOriginCourses(List<CourseDTO> originCourses) {
        this.originCourses = originCourses;
    }

    public List<CourseDTO> getDestinationCourses() {
        return destinationCourses;
    }

    public void setDestinationCourses(List<CourseDTO> destinationCourses) {
        this.destinationCourses = destinationCourses;
    }
}
