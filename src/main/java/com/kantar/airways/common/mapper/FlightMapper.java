package com.kantar.airways.common.mapper;

import org.mapstruct.Mapper;

import com.kantar.airways.domain.entity.FlightEntity;
import com.kantar.airways.service.flight.model.dto.FlightDTO;

@Mapper(componentModel = "spring")
public interface FlightMapper {

    FlightDTO flightToFlightDto(FlightEntity flight);

    FlightEntity flightDtoToFlight(FlightDTO flight);

}
