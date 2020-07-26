package com.kantar.airways.controller.airline;

import com.kantar.airways.common.exception.BusinessException;
import com.kantar.airways.service.airline.AirlineService;
import com.kantar.airways.service.airline.model.request.RequestCreateAirline;
import com.kantar.airways.service.airline.model.request.RequestGetAirline;
import com.kantar.airways.service.airline.model.request.RequestGetAllAirlines;
import com.kantar.airways.service.airline.model.response.ResponseCreateAirline;
import com.kantar.airways.service.airline.model.response.ResponseGetAirline;
import com.kantar.airways.service.airline.model.response.ResponseGetAllAirlines;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/airline")
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
	public ResponseCreateAirline create(@RequestBody RequestCreateAirline request) throws BusinessException {
		return service.createAirline(request);
	}
}
