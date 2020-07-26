package com.kantar.airways.service.course.model.request;

import com.kantar.airways.common.model.BaseRequest;

public class RequestCreateCourse extends BaseRequest {
	private String originAirportName;
	private String destinationAirportName;

	public String getOriginAirportName() {
		return originAirportName;
	}

	public void setOriginAirportName(String originAirportName) {
		this.originAirportName = originAirportName;
	}

	public String getDestinationAirportName() {
		return destinationAirportName;
	}

	public void setDestinationAirportName(String destinationAirportName) {
		this.destinationAirportName = destinationAirportName;
	}

}
