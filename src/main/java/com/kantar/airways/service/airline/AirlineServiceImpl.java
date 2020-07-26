package com.kantar.airways.service.airline;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kantar.airways.common.exception.AirwayBusinessException;
import com.kantar.airways.common.exception.AirwayNotFoundException;
import com.kantar.airways.common.mapper.AirlineMapper;
import com.kantar.airways.domain.entity.AirlineEntity;
import com.kantar.airways.domain.repository.AirlineRepository;
import com.kantar.airways.service.airline.model.dto.AirlineDTO;
import com.kantar.airways.service.airline.model.request.RequestCreateAirline;
import com.kantar.airways.service.airline.model.request.RequestGetAirline;
import com.kantar.airways.service.airline.model.request.RequestGetAllAirlines;
import com.kantar.airways.service.airline.model.response.ResponseCreateAirline;
import com.kantar.airways.service.airline.model.response.ResponseGetAirline;
import com.kantar.airways.service.airline.model.response.ResponseGetAllAirlines;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class AirlineServiceImpl implements AirlineService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AirlineServiceImpl.class);

	@Autowired
	private AirlineRepository airlineRepository;

	@Autowired
	private AirlineMapper airlineMapper;

	@Override
	public ResponseGetAllAirlines getAllAirlines(RequestGetAllAirlines request) {
		ResponseGetAllAirlines response = new ResponseGetAllAirlines();

		List<AirlineDTO> airlines = new ArrayList<>();

		List<AirlineEntity> airlineEntityList = airlineRepository.findAll();

		airlineEntityList.forEach((entity) -> airlines.add(airlineMapper.airlineToAirlineDto(entity)));

		response.setAirlines(airlines);

		return response;
	}

	@Override
	public ResponseGetAirline getAirline(RequestGetAirline request) {
		ResponseGetAirline response = new ResponseGetAirline();

		Optional<AirlineEntity> airline = Optional.empty();

		if (Objects.nonNull(request.getId())) {
			airline = airlineRepository.findById(request.getId());
		} else {
			airline = airlineRepository.findByCompany(request.getName());
		}

		AirlineEntity entity = airline.orElseThrow(() -> new AirwayNotFoundException("Not found"));

		response.setAirline(airlineMapper.airlineToAirlineDto(entity));

		return response;
	}

	@Override
	public ResponseCreateAirline createAirline(RequestCreateAirline request) throws AirwayBusinessException {
		ResponseCreateAirline response = new ResponseCreateAirline();

		Optional<AirlineEntity> airline = airlineRepository.findByCompany(request.getName());

		if (airline.isPresent()) {
			LOGGER.warn("Airline already exists. Id: " + airline.get().getId());
			throw new AirwayBusinessException(1001L, "Airline already exists");
		}

		AirlineEntity entity = new AirlineEntity();
		entity.setCompany(request.getName());

		AirlineEntity airlineSaved = airlineRepository.save(entity);

		response.setAirlineId(airlineSaved.getId());

		return response;
	}

}
