package com.julio.flights.controller;

import com.julio.flights.controller.dto.Flight;
import com.julio.flights.exceptions.DuplicateFlightException;
import com.julio.flights.service.FlightService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.function.Predicate;

@ControllerAdvice
@RequestMapping("flights/v0/")
public class FlightController {

    Logger LOG = LoggerFactory.getLogger("FlightController");

    @Autowired
    FlightService flightService;

    @PostMapping("flights/")
    public ResponseEntity<Void> addFligthsByReference(Flight flight){
        LOG.info("addFligthsByReference Controller");

        Predicate<Long> isFlyIdDuplicated = flightId-> findFligthsByReference(flightId.toString()).getStatusCode() == HttpStatus.OK;
        
        if(isFlyIdDuplicated.test(flight.getId())){
            LOG.info("Duplicate flight{" + flight + "}");
            throw new DuplicateFlightException(flight.getId().toString());
        }

        flightService.addFligthsByReference(flight);

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Location" , "/flights/" + flight.getId());

        return new ResponseEntity(headers, HttpStatus.CREATED);

    }

    @GetMapping("flights/{id}")
    public ResponseEntity<Flight> findFligthsByReference(@PathVariable("id") String id) {
        LOG.info("findFligthsByReference Controller");
        Flight flight = flightService.findFligthsByReference(id);

        HttpStatus httpStatus;
        if (flight.getId() != null) {
            httpStatus = HttpStatus.OK;
        } else {
            httpStatus = HttpStatus.NO_CONTENT;
        }

        return new ResponseEntity<>(flight, httpStatus);

    }

}
