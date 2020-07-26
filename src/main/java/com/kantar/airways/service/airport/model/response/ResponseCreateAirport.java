package com.kantar.airways.service.airport.model.response;

import com.kantar.airways.common.model.BaseResponse;

public class ResponseCreateAirport extends BaseResponse {
	private Long airportId;

	public Long getAirportId() {
		return airportId;
	}

	public void setAirportId(Long airportId) {
		this.airportId = airportId;
	}

}
