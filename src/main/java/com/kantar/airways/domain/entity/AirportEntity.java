package com.kantar.airways.domain.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "AIRPORT")
public class AirportEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String name;

    private String city;

    @OneToMany(mappedBy = "originAirport", fetch = FetchType.LAZY)
    private List<CourseEntity> originCourses;

    @OneToMany(mappedBy = "destinationAirport", fetch = FetchType.LAZY)
    private List<CourseEntity> destinationCourses;

    public AirportEntity() {
    }

    public AirportEntity(Long id, String name, String city) {
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

    public List<CourseEntity> getOriginCourses() {
        return originCourses;
    }

    public void setOriginCourses(List<CourseEntity> originCourses) {
        this.originCourses = originCourses;
    }

    public List<CourseEntity> getDestinationCourses() {
        return destinationCourses;
    }

    public void setDestinationCourses(List<CourseEntity> destinationCourses) {
        this.destinationCourses = destinationCourses;
    }

    @Override
    public String toString() {
        return "AirportEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", originCourses=" + originCourses +
                ", destinationCourses=" + destinationCourses +
                '}';
    }
}