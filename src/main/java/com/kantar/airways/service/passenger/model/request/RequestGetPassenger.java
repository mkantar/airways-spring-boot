package com.kantar.airways.service.passenger.model.request;

import com.kantar.airways.common.model.BaseRequest;

public class RequestGetPassenger extends BaseRequest {
    private Long id;

    public RequestGetPassenger() {
    }

    public RequestGetPassenger(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
