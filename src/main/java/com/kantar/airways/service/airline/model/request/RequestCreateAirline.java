package com.kantar.airways.service.airline.model.request;

import com.kantar.airways.common.model.BaseRequest;

public class RequestCreateAirline extends BaseRequest {
    private String name;

    public RequestCreateAirline() {
    }

    public RequestCreateAirline(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
