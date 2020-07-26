package com.kantar.airways.service.flight.model.response;

import com.kantar.airways.common.model.BaseResponse;
import com.kantar.airways.service.flight.model.dto.FlightDTO;

public class ResponseGetFlight extends BaseResponse {
	private FlightDTO flight;

	public FlightDTO getFlight() {
		return flight;
	}

	public void setFlight(FlightDTO flight) {
		this.flight = flight;
	}
}
