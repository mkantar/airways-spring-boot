package com.kantar.airways.service.airport.model.request;

import com.kantar.airways.common.model.BaseRequest;

public class RequestGetAirport extends BaseRequest {
	private Long id;
	private String name;

	public RequestGetAirport() {
	}

	public RequestGetAirport(Long id) {
		this.id = id;
	}

	public RequestGetAirport(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
