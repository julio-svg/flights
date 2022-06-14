package com.julio.flights.exceptions.handler;

import com.julio.flights.exceptions.DuplicateFlightException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class FlightControllerAdvice {


    @ExceptionHandler(value = DuplicateFlightException.class)
    public ResponseEntity<Void> duplicateFlightException(DuplicateFlightException ex){
        System.out.println(" entro "  + ex );
        return new ResponseEntity(HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<Void> duplicateFlightException2(RuntimeException ex){
        System.out.println(" entro "  + ex );
        return new ResponseEntity(HttpStatus.CONFLICT);
    }
}
