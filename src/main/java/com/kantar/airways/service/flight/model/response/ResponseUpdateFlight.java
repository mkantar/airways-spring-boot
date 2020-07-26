package com.kantar.airways.service.flight.model.response;

import com.kantar.airways.common.model.BaseResponse;

import java.math.BigDecimal;

public class ResponseUpdateFlight extends BaseResponse {
	private Long id;
	private Integer avialableSeat;
	private BigDecimal currentFee;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAvialableSeat() {
		return avialableSeat;
	}

	public void setAvialableSeat(Integer avialableSeat) {
		this.avialableSeat = avialableSeat;
	}

	public BigDecimal getCurrentFee() {
		return currentFee;
	}

	public void setCurrentFee(BigDecimal currentFee) {
		this.currentFee = currentFee;
	}

}
