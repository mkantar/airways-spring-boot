package com.kantar.airways.service.checkout;

import com.kantar.airways.common.exception.BusinessException;
import com.kantar.airways.common.exception.NotFoundException;
import com.kantar.airways.common.mapper.PassengerMapper;
import com.kantar.airways.common.mapper.PaymentMapper;
import com.kantar.airways.domain.entity.PaymentEntity;
import com.kantar.airways.domain.repository.PaymentRepository;
import com.kantar.airways.domain.vo.CreditCard;
import com.kantar.airways.service.checkout.model.request.RequestChargeFee;
import com.kantar.airways.service.checkout.model.response.ResponseChargeFee;
import com.kantar.airways.service.flight.FlightService;
import com.kantar.airways.service.ticket.TicketService;
import com.kantar.airways.service.ticket.model.dto.TicketDTO;
import com.kantar.airways.service.ticket.model.request.RequestGetTicket;
import com.kantar.airways.service.ticket.model.response.ResponseGetTicket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CheckoutServiceImpl implements CheckoutService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CheckoutServiceImpl.class);

	@Autowired
	PaymentMapper paymentMapper;

	@Autowired
	PassengerMapper passengerMapper;

	@Autowired
	PaymentRepository paymentRepository;

	@Autowired
	TicketService ticketService;

	@Autowired
	FlightService flightService;

	@Override
	public ResponseChargeFee chargeFee(RequestChargeFee request) throws BusinessException {
		ResponseChargeFee response = new ResponseChargeFee();

		try {
			ResponseGetTicket responseGetTicket = ticketService.getTicket(new RequestGetTicket(request.getTicketId()));

			TicketDTO ticketDto = responseGetTicket.getTicket();

			PaymentEntity paymentEntity = new PaymentEntity();
			paymentEntity.setChargeAmount(ticketDto.getFlight().getFee());
			paymentEntity.setPassenger(passengerMapper.passengerDtoToPassenger(ticketDto.getPassenger()));
			paymentEntity.setCreditCardNumber(CreditCard.from(request.getCreditCardNumber()).toString());

			PaymentEntity paymentSaved = paymentRepository.save(paymentEntity);
			paymentRepository.flush();

			response.setPayment(paymentMapper.paymentToPaymentDto(paymentSaved));
		} catch (NotFoundException e) {
			LOGGER.error("Cannot find the given ticket. Error: ", e);

			throw new BusinessException(9001L, "Cannot charge the fee");
		}

		return response;
	}
}
