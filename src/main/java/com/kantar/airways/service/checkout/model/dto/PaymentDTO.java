package com.kantar.airways.service.checkout.model.dto;

import com.kantar.airways.service.passenger.model.dto.PassengerDTO;

import java.io.Serializable;
import java.math.BigDecimal;

public class PaymentDTO implements Serializable {
    private Long id;
    private String creditCardNumber;
    private BigDecimal chargeAmount;
    private PassengerDTO passenger;

    public PaymentDTO() {
    }

    public PaymentDTO(Long id, String creditCardNumber, BigDecimal chargeAmount, PassengerDTO passenger) {
        this.id = id;
        this.creditCardNumber = creditCardNumber;
        this.chargeAmount = chargeAmount;
        this.passenger = passenger;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public BigDecimal getChargeAmount() {
        return chargeAmount;
    }

    public void setChargeAmount(BigDecimal chargeAmount) {
        this.chargeAmount = chargeAmount;
    }

    public PassengerDTO getPassenger() {
        return passenger;
    }

    public void setPassenger(PassengerDTO passenger) {
        this.passenger = passenger;
    }
}
