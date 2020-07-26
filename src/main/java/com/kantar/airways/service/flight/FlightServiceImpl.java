package com.kantar.airways.service.flight;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
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
import com.kantar.airways.service.flight.model.request.RequestCheckFlight;
import com.kantar.airways.service.flight.model.request.RequestCreateFlight;
import com.kantar.airways.service.flight.model.request.RequestGetAllFlights;
import com.kantar.airways.service.flight.model.request.RequestGetFlight;
import com.kantar.airways.service.flight.model.request.RequestUpdateFlight;
import com.kantar.airways.service.flight.model.response.ResponseCheckFlight;
import com.kantar.airways.service.flight.model.response.ResponseCreateFlight;
import com.kantar.airways.service.flight.model.response.ResponseGetAllFlights;
import com.kantar.airways.service.flight.model.response.ResponseGetFlight;
import com.kantar.airways.service.flight.model.response.ResponseUpdateFlight;

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
		
		List<FlightDTO> flightDtoList = new ArrayList<>();
		
		flightList.forEach((entity) -> { flightDtoList.add(flightMapper.flightToFlightDto(entity)); });
		
		response.setFlights(flightDtoList);
		
		return response;
	}

	@Override
	public ResponseGetFlight getFlight(RequestGetFlight request) {
		ResponseGetFlight response = new ResponseGetFlight();
		
		Optional<FlightEntity> flight = flightRepository.findById(request.getId());
		
		FlightEntity entity = flight.orElseThrow(() -> new AirwayNotFoundException("Not found"));
		
		response.setFlight(flightMapper.flightToFlightDto(entity));
		
		return response;
	}

	@Override
	public ResponseCreateFlight createFlight(RequestCreateFlight request) throws AirwayBusinessException {
		ResponseCreateFlight response = new ResponseCreateFlight();
		
		try { 
			ResponseGetAirline responseGetAirline = airlineService.getAirline(new RequestGetAirline(request.getAirlineName()));
			ResponseGetCourse responseGetCourse = courseService.getCourse(new RequestGetCourse(request.getCourseId()));
			
			FlightEntity entity = new FlightEntity();
			entity.setAirline(airlineMapper.airlineDtoToAirline(responseGetAirline.getAirline()));
			entity.setCourse(courseMapper.courseDtoToCourse(responseGetCourse.getCourse()));
			
			entity.setFee(request.getBaseFee());
			entity.setTotalSeat(request.getTotalSeat());
			entity.setDate(LocalDateTime.parse(request.getDepartureTime(), FORMATTER));
			
			FlightEntity flightSaved = flightRepository.save(entity);
			flightRepository.flush();
			
			response.setFlightId(flightSaved.getId());
		} catch (AirwayNotFoundException e) {
			LOGGER.error("Either airline or course has not been found. Error: ", e);
			
			throw new AirwayBusinessException(4001L, "Cannot set flight");
		}
		
		return response;
	}

	@Override
	public ResponseCheckFlight checkFlight(RequestCheckFlight request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseUpdateFlight updateFlight(RequestUpdateFlight request) {
		// TODO Auto-generated method stub
		return null;
	}
}
