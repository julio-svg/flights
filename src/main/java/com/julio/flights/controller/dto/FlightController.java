package com.julio.flights.controller.dto;

import com.julio.flights.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        ResponseEntity<Void> responseEntity = new ResponseEntity(headers, HttpStatus.CREATED);

        return responseEntity;

    }

}
