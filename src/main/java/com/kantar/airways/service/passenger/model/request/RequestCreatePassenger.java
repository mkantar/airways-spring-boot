package com.kantar.airways.service.passenger.model.request;

import com.kantar.airways.common.model.BaseRequest;
import com.kantar.airways.service.passenger.model.dto.PassengerDTO;

public class RequestCreatePassenger extends BaseRequest {
    private PassengerDTO passenger;

    public PassengerDTO getPassenger() {
        return passenger;
    }

    public void setPassenger(PassengerDTO passenger) {
        this.passenger = passenger;
    }

}
