package com.kantar.airways.service.flight;

import com.kantar.airways.common.exception.AirwayBusinessException;
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

public interface FlightService {
	
	ResponseGetAllFlights getAllFlights(RequestGetAllFlights request);
	
	ResponseGetFlight getFlight(RequestGetFlight request);
	
	ResponseCreateFlight createFlight(RequestCreateFlight request) throws AirwayBusinessException;
	
	ResponseCheckFlight checkFlight(RequestCheckFlight request);
	
	ResponseUpdateFlight updateFlight(RequestUpdateFlight request);
	
}
