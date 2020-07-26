package com.kantar.airways.service.checkout.model.request;

import com.kantar.airways.common.model.BaseRequest;

public class RequestChargeFee extends BaseRequest {
    private Long ticketId;
    private String creditCardNumber;

    public RequestChargeFee() {
    }

    public RequestChargeFee(Long ticketId, String creditCardNumber) {
        this.ticketId = ticketId;
        this.creditCardNumber = creditCardNumber;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }
}
