package com.kantar.airways.common.mapper;

import com.kantar.airways.domain.entity.AirportEntity;
import com.kantar.airways.service.airport.model.dto.AirportDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AirportMapper {

    AirportDTO airportToAirportDto(AirportEntity airport);

    AirportEntity airportDtoToAirport(AirportDTO airport);

}
