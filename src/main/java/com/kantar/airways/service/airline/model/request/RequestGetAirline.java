package com.kantar.airways.service.airline.model.request;

import com.kantar.airways.common.model.BaseRequest;

public class RequestGetAirline extends BaseRequest {
	private Long id;
	private String name;

	public RequestGetAirline() {
	}

	public RequestGetAirline(Long id) {
		this.id = id;
	}

	public RequestGetAirline(String name) {
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
