package com.kantar.airways.service.passenger.model.dto;

import com.kantar.airways.service.checkout.model.dto.PaymentDTO;
import com.kantar.airways.service.ticket.model.dto.TicketDTO;

import java.io.Serializable;
import java.util.List;

public class PassengerDTO implements Serializable {
    private Long id;
    private String name;
    private String surname;

    public PassengerDTO() {
    }

    public PassengerDTO(Long id, String name, String surname) {
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

}
