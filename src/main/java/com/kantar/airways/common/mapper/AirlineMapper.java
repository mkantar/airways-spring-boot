package com.kantar.airways.common.mapper;

import org.mapstruct.Mapper;

import com.kantar.airways.domain.entity.AirlineEntity;
import com.kantar.airways.service.airline.model.dto.AirlineDTO;

@Mapper(componentModel = "spring")
public interface AirlineMapper {

    AirlineDTO airlineToAirlineDto(AirlineEntity airline);

    AirlineEntity airlineDtoToAirline(AirlineDTO airline);

}
