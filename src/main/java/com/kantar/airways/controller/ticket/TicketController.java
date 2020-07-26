package com.kantar.airways.controller.ticket;

import com.kantar.airways.common.exception.BusinessException;
import com.kantar.airways.service.ticket.TicketService;
import com.kantar.airways.service.ticket.model.request.RequestBookTicket;
import com.kantar.airways.service.ticket.model.request.RequestCancelBookTicket;
import com.kantar.airways.service.ticket.model.request.RequestGetTicket;
import com.kantar.airways.service.ticket.model.response.ResponseBookTicket;
import com.kantar.airways.service.ticket.model.response.ResponseCancelBookTicket;
import com.kantar.airways.service.ticket.model.response.ResponseGetTicket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/ticket")
public class TicketController {

	@Autowired
	TicketService service;

	@GetMapping("/{id}")
	public ResponseGetTicket getTicket(@PathVariable Long id) {
		return service.getTicket(new RequestGetTicket(id));
	}

	@PostMapping
	public ResponseBookTicket bookTicket(@RequestBody RequestBookTicket request) throws BusinessException {
		return service.bookTicket(request);
	}

	@DeleteMapping("/{id}")
	public ResponseCancelBookTicket cancelTicket(@PathVariable Long id) throws BusinessException {
		return service.cancelBookTicket(new RequestCancelBookTicket(id));
	}

}
