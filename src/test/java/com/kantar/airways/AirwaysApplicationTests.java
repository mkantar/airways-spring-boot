package com.kantar.airways;

import com.kantar.airways.controller.airline.AirlineController;
import com.kantar.airways.controller.airport.AirportController;
import com.kantar.airways.controller.checkout.CheckoutController;
import com.kantar.airways.controller.course.CourseController;
import com.kantar.airways.controller.flight.FlightController;
import com.kantar.airways.controller.ticket.TicketController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
class AirwaysApplicationTests {

	@Autowired
	AirlineController airlineController;

	@Autowired
	AirportController airportController;

	@Autowired
	CheckoutController checkoutController;

	@Autowired
	CourseController courseController;

	@Autowired
	FlightController flightController;

	@Autowired
	TicketController ticketController;

	@Test
	void contextLoads() {
		assertThat(airlineController, is(notNullValue()));
		assertThat(airportController, is(notNullValue()));
		assertThat(checkoutController, is(notNullValue()));
		assertThat(courseController, is(notNullValue()));
		assertThat(flightController, is(notNullValue()));
		assertThat(ticketController, is(notNullValue()));
	}

}
