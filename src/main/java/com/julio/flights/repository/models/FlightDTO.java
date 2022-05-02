package com.julio.flights.repository.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
public class FlightDTO {

    @Id
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "departure_time")
    private LocalDateTime departureTime;
    private String origin;
    private String destination;


}
