package com.kantar.airways.service.airline;

import com.kantar.airways.common.exception.BusinessException;
import com.kantar.airways.service.airline.model.request.RequestCreateAirline;
import com.kantar.airways.service.airline.model.request.RequestGetAirline;
import com.kantar.airways.service.airline.model.request.RequestGetAllAirlines;
import com.kantar.airways.service.airline.model.response.ResponseCreateAirline;
import com.kantar.airways.service.airline.model.response.ResponseGetAirline;
import com.kantar.airways.service.airline.model.response.ResponseGetAllAirlines;

public interface AirlineService {
	
	ResponseGetAllAirlines getAllAirlines(RequestGetAllAirlines request);
	
	ResponseGetAirline getAirline(RequestGetAirline request);

	ResponseCreateAirline createAirline(RequestCreateAirline request) throws BusinessException;


}
