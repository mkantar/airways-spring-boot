package com.kantar.airways.service.flight.model.response;

import com.kantar.airways.common.model.BaseResponse;

public class ResponseCreateFlight extends BaseResponse {
	private Long flightId;

	public Long getFlightId() {
		return flightId;
	}

	public void setFlightId(Long flightId) {
		this.flightId = flightId;
	}

}
