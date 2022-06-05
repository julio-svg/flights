package com.julio.flights.controller.dto;

import com.julio.flights.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("flights/v0/")
public class FlightController {

    @Autowired
    FlightService flightService;

    @PostMapping("flights/")
    public ResponseEntity<Void> addFligthsByReference(Flight flight){
        flightService.addFligthsByReference(flight);

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Location" , "/flights/" + flight.getId());
        return new ResponseEntity(headers, HttpStatus.CREATED);

    }

    @GetMapping("flights/{id}")
    public ResponseEntity<Flight> findFligthsByReference(@PathVariable("id") String id) {
        Flight flight = flightService.findFligthsByReference(id);

        HttpStatus httpStatus;
        if (flight != null) {
            httpStatus = HttpStatus.OK;
        } else {
            httpStatus = HttpStatus.NO_CONTENT;
        }

        return new ResponseEntity<>(flight, httpStatus);

    }

}
