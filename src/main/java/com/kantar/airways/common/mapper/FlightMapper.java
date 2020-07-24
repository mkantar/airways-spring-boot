package com.kantar.airways.common.mapper;

import com.kantar.airways.domain.entity.FlightEntity;
import com.kantar.airways.service.flight.model.dto.FlightDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FlightMapper {

    FlightDTO flightToFlightDto(FlightEntity flight);

    FlightEntity flightDtoToFlight(FlightDTO flight);

}
