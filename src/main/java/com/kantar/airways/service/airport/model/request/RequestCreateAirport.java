package com.kantar.airways.service.airport.model.request;

import com.kantar.airways.common.model.BaseRequest;

public class RequestCreateAirport extends BaseRequest {
	private String name;
	private String city;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
