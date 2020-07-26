package com.kantar.airways.service.ticket.model.request;

import com.kantar.airways.common.model.BaseRequest;

public class RequestBookTicket extends BaseRequest {
    private Long passengerId;
    private Long flightId;

    public RequestBookTicket() {
    }

    public RequestBookTicket(Long passengerId, Long flightId) {
        this.passengerId = passengerId;
        this.flightId = flightId;
    }

    public Long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Long passengerId) {
        this.passengerId = passengerId;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

}
