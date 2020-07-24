package com.kantar.airways.domain.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "COURSE")
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "originId", nullable = false)
    private AirportEntity originAirport;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "destinationId", nullable = false)
    private AirportEntity destinationAirport;

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
    private List<FlightEntity> flights;

    public CourseEntity() {
    }

    public CourseEntity(Long id, AirportEntity originAirport, AirportEntity destinationAirport, List<FlightEntity> flights) {
        this.id = id;
        this.originAirport = originAirport;
        this.destinationAirport = destinationAirport;
        this.flights = flights;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AirportEntity getOriginAirport() {
        return originAirport;
    }

    public void setOriginAirport(AirportEntity originAirport) {
        this.originAirport = originAirport;
    }

    public AirportEntity getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(AirportEntity destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public List<FlightEntity> getFlights() {
        return flights;
    }

    public void setFlights(List<FlightEntity> flights) {
        this.flights = flights;
    }

    @Override
    public String toString() {
        return "CourseEntity{" +
                "id=" + id +
                ", originAirport=" + originAirport.getName() +
                ", destinationAirport=" + destinationAirport.getName() +
                ", flights=" + flights +
                '}';
    }
}
