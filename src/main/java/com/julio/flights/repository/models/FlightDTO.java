package com.julio.flights.repository.models;

import lombok.*;



import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class FlightDTO {

    @Id
    private Long id;
    @Column(name = "departure_time")
    private LocalDateTime departureTime;
    private String origin;
    private String destination;


}
