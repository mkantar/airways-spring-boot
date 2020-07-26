package com.kantar.airways.service.flight.model.response;

import java.util.List;

import com.kantar.airways.common.model.BaseResponse;
import com.kantar.airways.service.flight.model.dto.FlightDTO;

public class ResponseGetAllFlights extends BaseResponse {
	private List<FlightDTO> flights;

	public List<FlightDTO> getFlights() {
		return flights;
	}

	public void setFlights(List<FlightDTO> flights) {
		this.flights = flights;
	}
}
