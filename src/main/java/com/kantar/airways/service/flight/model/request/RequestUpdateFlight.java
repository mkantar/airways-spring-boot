package com.kantar.airways.service.flight.model.request;

import com.kantar.airways.common.model.BaseRequest;
import com.kantar.airways.service.flight.model.enums.FlightStatus;

public class RequestUpdateFlight extends BaseRequest {
    private Long id;
    private FlightStatus status;

    public RequestUpdateFlight() {
    }

    public RequestUpdateFlight(Long id, FlightStatus status) {
        this.id = id;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FlightStatus getStatus() {
        return status;
    }

    public void setStatus(FlightStatus status) {
        this.status = status;
    }

}
