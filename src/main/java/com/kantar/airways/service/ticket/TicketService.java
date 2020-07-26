package com.kantar.airways.service.ticket;

import com.kantar.airways.common.exception.BusinessException;
import com.kantar.airways.service.ticket.model.request.RequestBookTicket;
import com.kantar.airways.service.ticket.model.request.RequestCancelBookTicket;
import com.kantar.airways.service.ticket.model.request.RequestGetTicket;
import com.kantar.airways.service.ticket.model.response.ResponseBookTicket;
import com.kantar.airways.service.ticket.model.response.ResponseCancelBookTicket;
import com.kantar.airways.service.ticket.model.response.ResponseGetTicket;

public interface TicketService {

    ResponseGetTicket getTicket(RequestGetTicket request);

    ResponseBookTicket bookTicket(RequestBookTicket request) throws BusinessException;

    ResponseCancelBookTicket cancelBookTicket(RequestCancelBookTicket request) throws BusinessException;

}
