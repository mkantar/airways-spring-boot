package com.kantar.airways.service.airline.model.response;

import com.kantar.airways.common.model.BaseResponse;

public class ResponseCreateAirline extends BaseResponse {
    private Long airlineId;

    public ResponseCreateAirline() {
    }

    public ResponseCreateAirline(Long airlineId) {
        this.airlineId = airlineId;
    }

    public Long getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(Long airlineId) {
        this.airlineId = airlineId;
    }
}
