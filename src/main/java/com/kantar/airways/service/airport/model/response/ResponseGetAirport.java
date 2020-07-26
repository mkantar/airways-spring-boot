package com.kantar.airways.service.airport.model.response;

import com.kantar.airways.common.model.BaseResponse;
import com.kantar.airways.service.airport.model.dto.AirportDTO;

public class ResponseGetAirport extends BaseResponse {
	private AirportDTO airport;

	public AirportDTO getAirport() {
		return airport;
	}

	public void setAirport(AirportDTO airport) {
		this.airport = airport;
	}

}
