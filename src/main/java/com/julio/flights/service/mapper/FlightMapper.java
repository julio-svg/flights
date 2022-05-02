package com.julio.flights.service.mapper;

import com.julio.flights.controller.dto.Flight;
import com.julio.flights.repository.models.FlightDTO;

public class FlightMapper {
    public static FlightDTO fromFlightToFlightDTO(Flight flight) {
        return new FlightDTO(flight.getId(),flight.getDepartureTime(),flight.getOrigin(),flight.getDestination());

    }
}
