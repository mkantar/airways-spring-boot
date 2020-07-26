package com.kantar.airways.controller.airport;

import com.kantar.airways.common.exception.BusinessException;
import com.kantar.airways.service.airport.AirportService;
import com.kantar.airways.service.airport.model.request.RequestCreateAirport;
import com.kantar.airways.service.airport.model.request.RequestGetAirport;
import com.kantar.airways.service.airport.model.request.RequestGetAllAirports;
import com.kantar.airways.service.airport.model.response.ResponseCreateAirport;
import com.kantar.airways.service.airport.model.response.ResponseGetAirport;
import com.kantar.airways.service.airport.model.response.ResponseGetAllAirports;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/airport")
public class AirportController {
	
	@Autowired
	AirportService service;
	
	@GetMapping
	public ResponseGetAllAirports getAllAirports() {
		return service.getAllAirports(new RequestGetAllAirports());
	}
	
	@GetMapping("/{id}")
	public ResponseGetAirport getAirport(@PathVariable Long id) {
		return service.getAirport(new RequestGetAirport(id));
	}

	@PostMapping
	public ResponseCreateAirport createAirport(@RequestBody RequestCreateAirport request) throws BusinessException {
		return service.createAirport(request);
	}
}
