package com.kantar.airways.common.mapper;

import com.kantar.airways.domain.entity.PassengerEntity;
import com.kantar.airways.service.passenger.model.dto.PassengerDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PassengerMapper {

    PassengerDTO passengerToPassengerDto(PassengerEntity passenger);

    PassengerEntity passengerDtoToPassenger(PassengerDTO passenger);

}
