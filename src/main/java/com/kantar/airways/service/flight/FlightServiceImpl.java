package com.kantar.airways.service.flight;

import com.kantar.airways.common.exception.BusinessException;
import com.kantar.airways.common.exception.NotFoundException;
import com.kantar.airways.common.mapper.AirlineMapper;
import com.kantar.airways.common.mapper.CourseMapper;
import com.kantar.airways.common.mapper.FlightMapper;
import com.kantar.airways.domain.entity.FlightEntity;
import com.kantar.airways.domain.repository.FlightRepository;
import com.kantar.airways.service.airline.AirlineService;
import com.kantar.airways.service.airline.model.request.RequestGetAirline;
import com.kantar.airways.service.airline.model.response.ResponseGetAirline;
import com.kantar.airways.service.course.CourseService;
import com.kantar.airways.service.course.model.request.RequestGetCourse;
import com.kantar.airways.service.course.model.response.ResponseGetCourse;
import com.kantar.airways.service.flight.model.dto.FlightDTO;
import com.kantar.airways.service.flight.model.enums.FlightStatus;
import com.kantar.airways.service.flight.model.request.*;
import com.kantar.airways.service.flight.model.response.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class FlightServiceImpl implements FlightService {

	private static final Logger LOGGER = LoggerFactory.getLogger(FlightServiceImpl.class);

	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

	@Autowired
	FlightMapper flightMapper;

	@Autowired
	AirlineMapper airlineMapper;

	@Autowired
	CourseMapper courseMapper;

	@Autowired
	FlightRepository flightRepository;

	@Autowired
	AirlineService airlineService;

	@Autowired
	CourseService courseService;

	@Override
	public ResponseGetAllFlights getAllFlights(RequestGetAllFlights request) {
		ResponseGetAllFlights response = new ResponseGetAllFlights();

		List<FlightEntity> flightList = flightRepository.findAll();

		List<FlightDTO> flightDtoList = flightList.stream().map(entity -> flightMapper.flightToFlightDto(entity)).collect(Collectors.toList());

		response.setFlights(flightDtoList);

		return response;
	}

	@Override
	public ResponseGetFlight getFlight(RequestGetFlight request) {
		ResponseGetFlight response = new ResponseGetFlight();

		Optional<FlightEntity> flight = flightRepository.findById(request.getId());

		FlightEntity entity = flight.orElseThrow(() -> new NotFoundException("Not found"));

		response.setFlight(flightMapper.flightToFlightDto(entity));

		return response;
	}

	@Override
	public ResponseCreateFlight createFlight(RequestCreateFlight request) throws BusinessException {
		ResponseCreateFlight response = new ResponseCreateFlight();

		try {
			ResponseGetAirline responseGetAirline = airlineService
					.getAirline(new RequestGetAirline(request.getAirlineName()));
			ResponseGetCourse responseGetCourse = courseService.getCourse(new RequestGetCourse(request.getCourseId()));

			FlightEntity entity = new FlightEntity();
			entity.setAirline(airlineMapper.airlineDtoToAirline(responseGetAirline.getAirline()));
			entity.setCourse(courseMapper.courseDtoToCourse(responseGetCourse.getCourse()));

			entity.setFee(request.getBaseFee());
			entity.setTotalSeat(request.getTotalSeat());
			entity.setAvailableSeat(request.getTotalSeat());
			entity.setFactor(0.1F);
			entity.setDate(LocalDateTime.parse(request.getDepartureTime(), FORMATTER));

			FlightEntity flightSaved = flightRepository.save(entity);
			flightRepository.flush();

			response.setFlightId(flightSaved.getId());
		} catch (NotFoundException e) {
			LOGGER.error("Either airline or course has not been found. Error: ", e);

			throw new BusinessException(4001L, "Cannot set flight");
		}

		return response;
	}

	@Override
	public ResponseCheckFlight checkFlight(RequestCheckFlight request) {
		ResponseCheckFlight response = new ResponseCheckFlight();

		Optional<FlightEntity> flight = flightRepository.findById(request.getId());

		FlightEntity entity = flight.orElseThrow(() -> new NotFoundException("Not found"));

		response.setAvailable(entity.getTotalSeat() > entity.getAvailableSeat());
		response.setCurrentFee(entity.getFee());
		response.setAvailableSeatCount(entity.getAvailableSeat());

		return response;
	}

	@Override
	public ResponseUpdateFlight updateFlight(RequestUpdateFlight request) {
		ResponseUpdateFlight response = new ResponseUpdateFlight();

		Optional<FlightEntity> flight = flightRepository.findById(request.getId());

		FlightEntity entity = flight.orElseThrow(() -> new NotFoundException("Not Found"));

		if (FlightStatus.BOOK.equals(request.getStatus())) {
			int totalSeat = entity.getTotalSeat();
			int availableSeat = entity.getAvailableSeat() - 1;
			int percentageOfCapacity = (totalSeat - availableSeat) / totalSeat;

			if (isNewPriceEvaluated(percentageOfCapacity, entity.getFactor())) {
				BigDecimal newPrice = calculateNewPrice(entity.getFee());

				entity.setFactor(entity.getFactor() + 0.1f);
				entity.setFee(newPrice);
			}

			entity.setAvailableSeat(availableSeat);
		} else if (FlightStatus.CANCEL.equals(request.getStatus())) {
			int totalSeat = entity.getTotalSeat();
			int availableSeat = entity.getAvailableSeat() + 1;

			if (totalSeat > availableSeat) {
				entity.setAvailableSeat(availableSeat);
			}
		}

		FlightEntity flightUpdated = flightRepository.save(entity);
		flightRepository.flush();

		response.setAvialableSeat(flightUpdated.getAvailableSeat());
		response.setCurrentFee(flightUpdated.getFee());
		response.setId(flightUpdated.getId());

		return response;
	}

	private boolean isNewPriceEvaluated(float percentageOfCapacity, float factor) {
		return (percentageOfCapacity > factor);
	}

	private BigDecimal calculateNewPrice(BigDecimal currentPrice) {
		return currentPrice.add(currentPrice.multiply(BigDecimal.valueOf(0.1)));
	}
}
