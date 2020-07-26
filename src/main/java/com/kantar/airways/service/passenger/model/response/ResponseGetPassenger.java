package com.kantar.airways.service.passenger.model.response;

import com.kantar.airways.common.model.BaseResponse;
import com.kantar.airways.service.passenger.model.dto.PassengerDTO;

public class ResponseGetPassenger extends BaseResponse {
    private PassengerDTO passenger;

    public PassengerDTO getPassenger() {
        return passenger;
    }

    public void setPassenger(PassengerDTO passenger) {
        this.passenger = passenger;
    }
}
