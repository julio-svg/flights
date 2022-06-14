package com.julio.flights.service.impl;

import com.julio.flights.controller.dto.Flight;
import com.julio.flights.exceptions.DuplicateFlightException;
import com.julio.flights.repository.FlightRepository;
import com.julio.flights.repository.models.FlightDTO;
import com.julio.flights.service.FlightService;
import com.julio.flights.service.mapper.FlightMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class FlightServiceImpl implements FlightService {



    Logger LOG = LoggerFactory.getLogger("FlightServiceImpl");

    @Autowired
    FlightRepository flightRepository;

    @Override
    public void addFligthsByReference(Flight flight) {
        LOG.info("addFligthsByReference Service");

        flightRepository.save( FlightMapper.fromFlightToFlightDTO(flight));

    }

    @Override
    public Flight findFligthsByReference(String id) {
        LOG.info("findFligthsByReference Service");
        return FlightMapper.fromFlightDTOToFlight(flightRepository.findById(Long.parseLong(id)).orElse(new FlightDTO()));
    }
}
