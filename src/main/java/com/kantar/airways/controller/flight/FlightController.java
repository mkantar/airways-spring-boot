package com.kantar.airways.controller.flight;

import com.kantar.airways.common.exception.BusinessException;
import com.kantar.airways.service.flight.FlightService;
import com.kantar.airways.service.flight.model.request.RequestCreateFlight;
import com.kantar.airways.service.flight.model.request.RequestGetAllFlights;
import com.kantar.airways.service.flight.model.request.RequestGetFlight;
import com.kantar.airways.service.flight.model.response.ResponseCreateFlight;
import com.kantar.airways.service.flight.model.response.ResponseGetAllFlights;
import com.kantar.airways.service.flight.model.response.ResponseGetFlight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/flight")
public class FlightController {

	@Autowired
	FlightService service;

	@GetMapping
	public ResponseGetAllFlights getAllFlights() {
		return service.getAllFlights(new RequestGetAllFlights());
	}

	@GetMapping("/{id}")
	public ResponseGetFlight getFlight(@PathVariable Long id) {
		return service.getFlight(new RequestGetFlight(id));
	}

	@PostMapping
	public ResponseCreateFlight createFlight(@RequestBody RequestCreateFlight request) throws BusinessException {
		return service.createFlight(request);
	}

}
