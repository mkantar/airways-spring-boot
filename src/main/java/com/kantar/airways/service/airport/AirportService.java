package com.kantar.airways.service.airport;

import com.kantar.airways.common.exception.BusinessException;
import com.kantar.airways.service.airport.model.request.RequestCreateAirport;
import com.kantar.airways.service.airport.model.request.RequestGetAirport;
import com.kantar.airways.service.airport.model.request.RequestGetAllAirports;
import com.kantar.airways.service.airport.model.response.ResponseCreateAirport;
import com.kantar.airways.service.airport.model.response.ResponseGetAirport;
import com.kantar.airways.service.airport.model.response.ResponseGetAllAirports;

public interface AirportService {

    ResponseGetAllAirports getAllAirports(RequestGetAllAirports request);

    ResponseGetAirport getAirport(RequestGetAirport request);

    ResponseCreateAirport createAirport(RequestCreateAirport request) throws BusinessException;
}
