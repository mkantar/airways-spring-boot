package com.kantar.airways.service.airline.model.response;

import java.util.List;

import com.kantar.airways.common.model.BaseResponse;
import com.kantar.airways.service.airline.model.dto.AirlineDTO;

public class ResponseGetAllAirlines extends BaseResponse {
	private List<AirlineDTO> airlines;

	public List<AirlineDTO> getAirlines() {
		return airlines;
	}

	public void setAirlines(List<AirlineDTO> airlines) {
		this.airlines = airlines;
	}

}
