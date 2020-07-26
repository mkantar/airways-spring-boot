package com.kantar.airways.service.flight;

import com.kantar.airways.common.exception.BusinessException;
import com.kantar.airways.service.flight.model.request.*;
import com.kantar.airways.service.flight.model.response.*;

public interface FlightService {

	ResponseGetAllFlights getAllFlights(RequestGetAllFlights request);

	ResponseGetFlight getFlight(RequestGetFlight request);

	ResponseCreateFlight createFlight(RequestCreateFlight request) throws BusinessException;

	ResponseCheckFlight checkFlight(RequestCheckFlight request);

	ResponseUpdateFlight updateFlight(RequestUpdateFlight request);

}
