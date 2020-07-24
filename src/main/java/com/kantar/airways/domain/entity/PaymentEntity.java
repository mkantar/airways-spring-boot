package com.kantar.airways.domain.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "PAYMENT")
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String creditCardNumber;

    private BigDecimal chargeAmount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "passengerId", nullable = false)
    private PassengerEntity passenger;

    public PaymentEntity() {
    }

    public PaymentEntity(Long id, String creditCardNumber, BigDecimal chargeAmount, PassengerEntity passenger) {
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

    public PassengerEntity getPassenger() {
        return passenger;
    }

    public void setPassenger(PassengerEntity passenger) {
        this.passenger = passenger;
    }

    @Override
    public String toString() {
        return "PaymentEntity{" +
                "id=" + id +
                ", creditCardNumber='" + creditCardNumber + '\'' +
                ", chargeAmount=" + chargeAmount +
                '}';
    }
}
