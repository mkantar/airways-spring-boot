package com.kantar.airways.controller.airline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kantar.airways.common.exception.AirwayBusinessException;
import com.kantar.airways.service.airline.AirlineService;
import com.kantar.airways.service.airline.model.request.RequestCreateAirline;
import com.kantar.airways.service.airline.model.request.RequestGetAirline;
import com.kantar.airways.service.airline.model.request.RequestGetAllAirlines;
import com.kantar.airways.service.airline.model.response.ResponseCreateAirline;
import com.kantar.airways.service.airline.model.response.ResponseGetAirline;
import com.kantar.airways.service.airline.model.response.ResponseGetAllAirlines;

@RestController
@RequestMapping(path = "airline")
public class AirlineController {
	
	@Autowired
	AirlineService service;
	
	@GetMapping
	public ResponseGetAllAirlines getAllAirlines() {
		return service.getAllAirlines(new RequestGetAllAirlines());
	}
	
	@GetMapping("/{id}") 
	public ResponseGetAirline getAirline(@PathVariable Long id) {
		return service.getAirline(new RequestGetAirline(id));
	}
	
	@PostMapping
	public ResponseCreateAirline create(@RequestBody RequestCreateAirline request) throws AirwayBusinessException {
		return service.createAirline(request);
	}
}
