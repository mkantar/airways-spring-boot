package com.kantar.airways.service.ticket.model.request;

import com.kantar.airways.common.model.BaseRequest;

public class RequestGetTicket extends BaseRequest {
    private Long id;

    public RequestGetTicket() {
    }

    public RequestGetTicket(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
