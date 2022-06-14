package com.julio.flights.exceptions;

public class DuplicateFlightException extends RuntimeException{

    public DuplicateFlightException(String id) {
        super("El vuelo " + id + " se encuentra actualmente en DB");

    }

    private static final long serialVersionUID = 1L;
}
