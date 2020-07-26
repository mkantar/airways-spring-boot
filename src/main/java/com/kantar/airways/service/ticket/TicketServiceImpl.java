package com.kantar.airways.service.ticket;

import com.kantar.airways.common.exception.BusinessException;
import com.kantar.airways.common.exception.NotFoundException;
import com.kantar.airways.common.mapper.FlightMapper;
import com.kantar.airways.common.mapper.PassengerMapper;
import com.kantar.airways.common.mapper.TicketMapper;
import com.kantar.airways.domain.entity.TicketEntity;
import com.kantar.airways.domain.repository.TicketRepository;
import com.kantar.airways.service.flight.FlightService;
import com.kantar.airways.service.flight.model.enums.FlightStatus;
import com.kantar.airways.service.flight.model.request.RequestCheckFlight;
import com.kantar.airways.service.flight.model.request.RequestGetFlight;
import com.kantar.airways.service.flight.model.request.RequestUpdateFlight;
import com.kantar.airways.service.flight.model.response.ResponseCheckFlight;
import com.kantar.airways.service.flight.model.response.ResponseGetFlight;
import com.kantar.airways.service.passenger.PassengerService;
import com.kantar.airways.service.passenger.model.request.RequestGetPassenger;
import com.kantar.airways.service.passenger.model.response.ResponseGetPassenger;
import com.kantar.airways.service.ticket.model.request.RequestBookTicket;
import com.kantar.airways.service.ticket.model.request.RequestCancelBookTicket;
import com.kantar.airways.service.ticket.model.request.RequestGetTicket;
import com.kantar.airways.service.ticket.model.response.ResponseBookTicket;
import com.kantar.airways.service.ticket.model.response.ResponseCancelBookTicket;
import com.kantar.airways.service.ticket.model.response.ResponseGetTicket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class TicketServiceImpl implements TicketService {

	private static final Logger LOGGER = LoggerFactory.getLogger(TicketServiceImpl.class);

	@Autowired
	TicketMapper ticketMapper;

	@Autowired
	PassengerMapper passengerMapper;

	@Autowired
	FlightMapper flightMapper;

	@Autowired
	TicketRepository ticketRepository;

	@Autowired
	FlightService flightService;

	@Autowired
	PassengerService passengerService;

	@Override
	public ResponseGetTicket getTicket(RequestGetTicket request) {
		ResponseGetTicket response = new ResponseGetTicket();

		Optional<TicketEntity> ticket = ticketRepository.findById(request.getId());

		TicketEntity entity = ticket.orElseThrow(() -> new NotFoundException("Not Found"));

		response.setTicket(ticketMapper.ticketToTicketDto(entity));

		return response;
	}

	@Override
	public ResponseBookTicket bookTicket(RequestBookTicket request) throws BusinessException {
		ResponseBookTicket response = new ResponseBookTicket();

		try {
			ResponseCheckFlight responseCheckFlight = flightService.checkFlight(new RequestCheckFlight(request.getFlightId()));

			if (responseCheckFlight.isAvailable()) {
				ResponseGetPassenger responseGetPassenger = passengerService.getPassenger(new RequestGetPassenger(request.getPassengerId()));
				ResponseGetFlight responseGetFlight = flightService.getFlight(new RequestGetFlight(request.getFlightId()));

				TicketEntity entity = new TicketEntity();
				entity.setFlight(flightMapper.flightDtoToFlight(responseGetFlight.getFlight()));
				entity.setPassenger(passengerMapper.passengerDtoToPassenger(responseGetPassenger.getPassenger()));

				flightService.updateFlight(new RequestUpdateFlight(request.getFlightId(), FlightStatus.BOOK));

				TicketEntity ticketSaved = ticketRepository.save(entity);
				ticketRepository.flush();

				response.setTicket(ticketMapper.ticketToTicketDto(ticketSaved));
			} else {
				throw new BusinessException(7001L, "Cannot book a ticket. Capacity is full");
			}
		} catch (NotFoundException e) {
			LOGGER.error("Either passenger or flight info is missing");

			throw new BusinessException(7002L, "Either passenger or flight info is missing");
		}

		return response;
	}

	@Override
	public ResponseCancelBookTicket cancelBookTicket(RequestCancelBookTicket request) throws BusinessException {
		ResponseCancelBookTicket response = new ResponseCancelBookTicket();

		Optional<TicketEntity> ticket = ticketRepository.findById(request.getId());

		TicketEntity entity = ticket.orElseThrow(() -> new NotFoundException("Not found"));

		flightService.updateFlight(new RequestUpdateFlight(entity.getFlight().getId(), FlightStatus.CANCEL));

		ticketRepository.delete(entity);

		return response;
	}


}
