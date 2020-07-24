package com.kantar.airways.service.passenger.model.dto;

import com.kantar.airways.service.checkout.model.dto.PaymentDTO;
import com.kantar.airways.service.ticket.model.dto.TicketDTO;

import java.io.Serializable;
import java.util.List;

public class PassengerDTO implements Serializable {
    private Long id;
    private String name;
    private String surname;
    private List<TicketDTO> tickets;
    private List<PaymentDTO> payments;

    public PassengerDTO() {
    }

    public PassengerDTO(Long id, String name, String surname, List<TicketDTO> tickets, List<PaymentDTO> payments) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.tickets = tickets;
        this.payments = payments;
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

    public List<TicketDTO> getTickets() {
        return tickets;
    }

    public void setTickets(List<TicketDTO> tickets) {
        this.tickets = tickets;
    }

    public List<PaymentDTO> getPayments() {
        return payments;
    }

    public void setPayments(List<PaymentDTO> payments) {
        this.payments = payments;
    }
}
