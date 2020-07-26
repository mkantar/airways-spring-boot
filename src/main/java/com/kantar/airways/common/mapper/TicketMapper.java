package com.kantar.airways.common.mapper;

import org.mapstruct.Mapper;

import com.kantar.airways.domain.entity.TicketEntity;
import com.kantar.airways.service.ticket.model.dto.TicketDTO;

@Mapper(componentModel = "spring")
public interface TicketMapper {

    TicketDTO ticketToTicketDto(TicketEntity ticket);

    TicketEntity ticketDtoToTicket(TicketDTO ticket);

}
