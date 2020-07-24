package com.kantar.airways.domain.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PASSENGER")
public class PassengerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String surname;

    @OneToMany(mappedBy = "passenger", fetch = FetchType.LAZY)
    private List<TicketEntity> tickets;

    @OneToMany(mappedBy = "passenger", fetch = FetchType.LAZY)
    private List<PaymentEntity> payments;

    public PassengerEntity() {
    }

    public PassengerEntity(Long id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<TicketEntity> getTickets() {
        return tickets;
    }

    public void setTickets(List<TicketEntity> tickets) {
        this.tickets = tickets;
    }

    public List<PaymentEntity> getPayments() {
        return payments;
    }

    public void setPayments(List<PaymentEntity> payments) {
        this.payments = payments;
    }

    @Override
    public String toString() {
        return "PassengerEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
