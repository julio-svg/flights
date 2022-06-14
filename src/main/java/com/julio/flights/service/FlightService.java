package com.julio.flights.service;


import com.julio.flights.controller.dto.Flight;
import com.julio.flights.exceptions.DuplicateFlightException;


public interface FlightService {

    public void addFligthsByReference(Flight flight);

    public Flight findFligthsByReference(String id);
}
