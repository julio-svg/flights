package com.julio.flights;


import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import

@SpringBootTest
class FlightsApplicationTests {

	/* addFligthsByReference
	   findFligthsByReference
	   findFigsthsByOrigin
	   findFligthsByDate
	   deleteFligthsByReference
	 */

	@Test
	void contextLoads() {
	}

	@Test
	public void givenEmptyDatabaseFligth_whenFlightsAdd_thenFindFligthsByReferenceReturnFligth() {
		//when
		Flight flight = new Flight();
		flightController.addFligthsByReference(flight);

		//then
		Flight flightAdded = flightController.findFligthsByReference(flight.getId);
		assertEquals(flight,flightAdded);
	}


}
