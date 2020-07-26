package com.kantar.airways.service.passenger;

import com.kantar.airways.common.exception.BusinessException;
import com.kantar.airways.service.passenger.model.request.RequestCreatePassenger;
import com.kantar.airways.service.passenger.model.request.RequestGetPassenger;
import com.kantar.airways.service.passenger.model.response.ResponseCreatePassenger;
import com.kantar.airways.service.passenger.model.response.ResponseGetPassenger;

public interface PassengerService {

    ResponseGetPassenger getPassenger(RequestGetPassenger request);

    ResponseCreatePassenger createPassenger(RequestCreatePassenger request) throws BusinessException;
}
