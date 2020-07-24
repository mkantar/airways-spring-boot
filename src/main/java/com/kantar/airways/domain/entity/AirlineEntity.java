package com.kantar.airways.domain.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "AIRLINE")
public class AirlineEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String company;

    @OneToMany(mappedBy = "airline", fetch = FetchType.LAZY)
    private List<FlightEntity> flights;

    public AirlineEntity() {
    }

    public AirlineEntity(Long id, String company) {
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

    public List<FlightEntity> getFlights() {
        return flights;
    }

    public void setFlights(List<FlightEntity> flights) {
        this.flights = flights;
    }

    @Override
    public String toString() {
        return "AirlineEntity{" +
                "id=" + id +
                ", company='" + company + '\'' +
                '}';
    }
}
