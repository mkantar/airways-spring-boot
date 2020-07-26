package com.kantar.airways.service.passenger;

import com.kantar.airways.common.exception.BusinessException;
import com.kantar.airways.common.exception.NotFoundException;
import com.kantar.airways.common.mapper.PassengerMapper;
import com.kantar.airways.domain.entity.PassengerEntity;
import com.kantar.airways.domain.repository.PassengerRepository;
import com.kantar.airways.service.passenger.model.request.RequestCreatePassenger;
import com.kantar.airways.service.passenger.model.request.RequestGetPassenger;
import com.kantar.airways.service.passenger.model.response.ResponseCreatePassenger;
import com.kantar.airways.service.passenger.model.response.ResponseGetPassenger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class PassengerServiceImpl implements PassengerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(PassengerServiceImpl.class);

	@Autowired
	PassengerMapper passengerMapper;

	@Autowired
	PassengerRepository passengerRepository;

	@Override
	public ResponseGetPassenger getPassenger(RequestGetPassenger request) {
		ResponseGetPassenger response = new ResponseGetPassenger();

		Optional<PassengerEntity> passenger = passengerRepository.findById(request.getId());

		PassengerEntity entity = passenger.orElseThrow(() -> new NotFoundException("Not found"));

		response.setPassenger(passengerMapper.passengerToPassengerDto(entity));

		return response;
	}

	@Override
	public ResponseCreatePassenger createPassenger(RequestCreatePassenger request) throws BusinessException {
		ResponseCreatePassenger response = new ResponseCreatePassenger();

		Optional<PassengerEntity> passenger = passengerRepository.findById(request.getPassenger().getId());

		if (passenger.isPresent()) {
			LOGGER.warn("Passenger is already created.");

			throw new BusinessException(6001L, "Passenger is already defined");
		}

		PassengerEntity entity = passengerMapper.passengerDtoToPassenger(request.getPassenger());

		PassengerEntity passengerSaved = passengerRepository.save(entity);
		passengerRepository.flush();

		response.setId(passengerSaved.getId());

		return response;
	}

}
