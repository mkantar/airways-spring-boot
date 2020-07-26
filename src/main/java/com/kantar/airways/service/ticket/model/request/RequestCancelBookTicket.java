package com.kantar.airways.service.ticket.model.request;

import com.kantar.airways.common.model.BaseRequest;

public class RequestCancelBookTicket extends BaseRequest {
    private Long id;

    public RequestCancelBookTicket() {
    }

    public RequestCancelBookTicket(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
