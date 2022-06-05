package com.julio.flights.service.impl;

import com.julio.flights.controller.dto.Flight;
import com.julio.flights.repository.FlightRepository;
import com.julio.flights.repository.models.FlightDTO;
import com.julio.flights.service.FlightService;
import com.julio.flights.service.mapper.FlightMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;


@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Override

    public void addFligthsByReference(Flight flight) {

        flightRepository.save(FlightMapper.fromFlightToFlightDTO(flight));

    }

    @Override

    public Flight findFligthsByReference(String id) {
        System.out.println("flightRepository = " + flightRepository.findById(1L));
        return FlightMapper.fromFlightDTOToFlight(flightRepository.findById(Long.parseLong(id)).orElse(new FlightDTO()));
    }
}
