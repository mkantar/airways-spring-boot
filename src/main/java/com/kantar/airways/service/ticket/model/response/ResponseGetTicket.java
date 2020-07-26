package com.kantar.airways.service.ticket.model.response;

import com.kantar.airways.common.model.BaseResponse;
import com.kantar.airways.service.ticket.model.dto.TicketDTO;

public class ResponseGetTicket extends BaseResponse {
    private TicketDTO ticket;

    public TicketDTO getTicket() {
        return ticket;
    }

    public void setTicket(TicketDTO ticket) {
        this.ticket = ticket;
    }
}
