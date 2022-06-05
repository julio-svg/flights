package com.julio.flights;


import static org.junit.Assert.assertEquals;

import com.julio.flights.controller.dto.Flight;
import com.julio.flights.controller.dto.FlightController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@SpringBootTest
class FlightsApplicationTests {

	/* addFligthsByReference
	   findFligthsByReference
	   findFigsthsByOrigin
	   findFligthsByDate
	   deleteFligthsByReference
	 */

	@Autowired
	FlightController flightController;

	@Test
	public void givenEmptyDatabaseFligth_whenFlightsAdd_thenFindFligthsByReferenceReturnFligth() {
		//when

		Flight flight = new Flight(1L,LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS),"Madrid","Canarias");
		flightController.addFligthsByReference(flight);

		//then
		assertEquals(flight,flightController.findFligthsByReference("1").getBody());
	}


}
