package com.kantar.airways.service.airport.model.response;

import java.util.List;

import com.kantar.airways.common.model.BaseResponse;
import com.kantar.airways.service.airport.model.dto.AirportDTO;

public class ResponseGetAllAirports extends BaseResponse {
	private List<AirportDTO> airports;

	public List<AirportDTO> getAirports() {
		return airports;
	}

	public void setAirports(List<AirportDTO> airports) {
		this.airports = airports;
	}

}
