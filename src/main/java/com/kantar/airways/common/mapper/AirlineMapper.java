package com.kantar.airways.common.mapper;

import com.kantar.airways.domain.entity.AirlineEntity;
import com.kantar.airways.service.airline.model.dto.AirlineDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AirlineMapper {

    AirlineDTO airlineToAirlineDto(AirlineEntity airline);

    AirlineEntity airlineDtoToAirline(AirlineDTO airline);

}
