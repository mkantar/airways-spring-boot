package com.kantar.airways.service.airline;

import com.kantar.airways.common.mapper.AirlineMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirlineServiceImpl implements AirlineService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AirlineServiceImpl.class);

    @Autowired
    private AirlineMapper airlineMapper;

    @Override
    public ResponseCreateAirline createAirline(RequestCreateAirline request) {

    }

}
