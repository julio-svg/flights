package com.julio.flights.controller.dto;

import lombok.*;


import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Flight {

    private Long id;

    private LocalDateTime departureTime;
    private String origin;
    private String destination;

}
