package com.kantar.airways.service.flight.model.request;

import com.kantar.airways.common.model.BaseRequest;

public class RequestCheckFlight extends BaseRequest {
    private Long id;

    public RequestCheckFlight() {
        super();
    }

    public RequestCheckFlight(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
