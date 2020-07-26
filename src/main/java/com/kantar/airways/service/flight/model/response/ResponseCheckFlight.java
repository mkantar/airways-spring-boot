package com.kantar.airways.service.flight.model.response;

import com.kantar.airways.common.model.BaseResponse;

import java.math.BigDecimal;

public class ResponseCheckFlight extends BaseResponse {
	private boolean available;
	private Integer availableSeatCount;
	private BigDecimal currentFee;

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public Integer getAvailableSeatCount() {
		return availableSeatCount;
	}

	public void setAvailableSeatCount(Integer availableSeatCount) {
		this.availableSeatCount = availableSeatCount;
	}

	public BigDecimal getCurrentFee() {
		return currentFee;
	}

	public void setCurrentFee(BigDecimal currentFee) {
		this.currentFee = currentFee;
	}

}
