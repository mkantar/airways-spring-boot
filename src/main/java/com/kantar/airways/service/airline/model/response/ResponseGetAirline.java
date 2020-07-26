package com.kantar.airways.service.airline.model.response;

import com.kantar.airways.common.model.BaseResponse;
import com.kantar.airways.service.airline.model.dto.AirlineDTO;

public class ResponseGetAirline extends BaseResponse {
	private AirlineDTO airline;

	public AirlineDTO getAirline() {
		return airline;
	}

	public void setAirline(AirlineDTO airline) {
		this.airline = airline;
	}
}
