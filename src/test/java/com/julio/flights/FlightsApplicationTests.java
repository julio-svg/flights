package com.julio.flights;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.julio.flights.controller.dto.Flight;
import com.julio.flights.controller.dto.FlightController;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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

	@Test
	public void givenEmptyDatabaseFligth_whenWithOutFlightsAdd_thenFindFligthsByReferenceReturnNotFoundFligth() {

		//then
		ResponseEntity<Flight> response = flightController.findFligthsByReference("2");
		assertNotNull(response.getBody());
		assertEquals(HttpStatus.NOT_FOUND,response.getStatusCode());
	}

	@Test
	public void givenOneFligth_whenTryToAddFlightWithSameId_thenDuplicateFligthFligthException() {
		//when

		Flight flight = new Flight(3L,LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS),"Madrid","Canarias");
		flightController.addFligthsByReference(flight);
		//when

		Flight flight2 = new Flight(3L,LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS),"Madrid","Canarias");
		flightController.addFligthsByReference(flight2);

	}




}
