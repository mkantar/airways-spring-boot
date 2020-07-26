package com.kantar.airways.service.ticket.model.response;

import com.kantar.airways.common.model.BaseResponse;
import com.kantar.airways.service.ticket.model.dto.TicketDTO;

public class ResponseBookTicket extends BaseResponse {
    private TicketDTO ticket;

    public TicketDTO getTicket() {
        return ticket;
    }

    public void setTicket(TicketDTO ticket) {
        this.ticket = ticket;
    }

}
