package com.kantar.airways.service.airport;

import com.kantar.airways.common.exception.BusinessException;
import com.kantar.airways.common.exception.NotFoundException;
import com.kantar.airways.common.mapper.AirportMapper;
import com.kantar.airways.domain.entity.AirportEntity;
import com.kantar.airways.domain.repository.AirportRepository;
import com.kantar.airways.service.airport.model.dto.AirportDTO;
import com.kantar.airways.service.airport.model.request.RequestCreateAirport;
import com.kantar.airways.service.airport.model.request.RequestGetAirport;
import com.kantar.airways.service.airport.model.request.RequestGetAllAirports;
import com.kantar.airways.service.airport.model.response.ResponseCreateAirport;
import com.kantar.airways.service.airport.model.response.ResponseGetAirport;
import com.kantar.airways.service.airport.model.response.ResponseGetAllAirports;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class AirportServiceImpl implements AirportService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AirportServiceImpl.class);
	
	@Autowired
	AirportMapper airportMapper;
	
	@Autowired
	AirportRepository airportRepository;

	@Override
	public ResponseGetAllAirports getAllAirports(RequestGetAllAirports request) {
        ResponseGetAllAirports response = new ResponseGetAllAirports();

        List<AirportEntity> airportList = airportRepository.findAll();

        List<AirportDTO> airportDtoList = airportList.stream().map(entity -> airportMapper.airportToAirportDto(entity)).collect(Collectors.toList());

        response.setAirports(airportDtoList);

        return response;
    }

	@Override
	public ResponseGetAirport getAirport(RequestGetAirport request) {
        ResponseGetAirport response = new ResponseGetAirport();

        Optional<AirportEntity> airport = Optional.empty();

        if (Objects.nonNull(request.getId())) {
            airport = airportRepository.findById(request.getId());
        } else {
            airport = airportRepository.findByName(request.getName());
        }

        AirportEntity entity = airport.orElseThrow(() -> new NotFoundException("Not found"));

        response.setAirport(airportMapper.airportToAirportDto(entity));

        return response;
    }

    @Override
    public ResponseCreateAirport createAirport(RequestCreateAirport request) throws BusinessException {
        ResponseCreateAirport response = new ResponseCreateAirport();

        Optional<AirportEntity> airport = airportRepository.findByName(request.getName());

        if (airport.isPresent()) {
            LOGGER.warn("Airport already exists. Id: " + airport.get().getId());

            throw new BusinessException(1002L, "Airport already exists");
        }

        AirportEntity entity = new AirportEntity();
        entity.setCity(request.getCity());
        entity.setName(request.getName());

        AirportEntity airportSaved = airportRepository.save(entity);
        airportRepository.flush();

        response.setAirportId(airportSaved.getId());
		
		return response;
	}
}
