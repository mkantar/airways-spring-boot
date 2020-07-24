package com.kantar.airways.common.mapper;

import com.kantar.airways.domain.entity.TicketEntity;
import com.kantar.airways.service.ticket.model.dto.TicketDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TicketMapper {

    TicketDTO ticketToTicketDto(TicketEntity ticket);

    TicketEntity ticketDtoToTicket(TicketDTO ticket);

}
