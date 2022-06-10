package com.julio.flights;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


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
	*/

	@Autowired
	FlightController flightController;

	@Test
	public void givenEmptyDatabaseFligth_whenFlightsAdd_thenFindFligthsByReference_returnFligth() {
		//when
		Flight flight = new Flight(1L,LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS),"Madrid","Lanzarote");
		flightController.addFligthsByReference(flight);
		//then
		assertEquals(flight,flightController.findFligthsByReference("1").getBody());

	}

	@Test
	public void givenEmptyDatabaseFligth_whenWithOutFlightsAdd_thenFindFligthsByReference_returnNotFoundFligth() {
		//when
		ResponseEntity<Flight> response = flightController.findFligthsByReference("2");
		//then
		assertNotNull(response.getBody());
		assertEquals(HttpStatus.NOT_FOUND,response.getStatusCode());
	}

	@Test
	public void givenOneFlight_whenTryToAdd_thenAddFligth_returnOk(){
		//when
		Flight flight = new Flight(4L,LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS),"Madrid","Lanzarote");
		ResponseEntity<Void> response = flightController.addFligthsByReference(flight);
		//then
		assertEquals(HttpStatus.CREATED, response.getStatusCode());

	}

	@Test
	public void givenOneFligth_whenTryToAddFlightWithSameId_thenDuplicateFligthFligthException() {
		//when
		Flight flight = new Flight(3L,LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS),"Madrid","Lanzarote");
		flightController.addFligthsByReference(flight);
		Flight flight2 = new Flight(3L,LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS),"Madrid","Lanzarote");
		ResponseEntity<Void> response = flightController.addFligthsByReference(flight2);

		//then
		assertEquals(HttpStatus.CONFLICT, response.getStatusCode());

	}

}
