package com.julio.flights.controller.dto;

import lombok.Data;


import java.time.LocalDateTime;

@Data
public class Flight {

    private Long id;

    private LocalDateTime departureTime;
    private String origin;
    private String destination;
}
