package com.julio.flights.repository;


import com.julio.flights.repository.models.FlightDTO;
import org.springframework.data.repository.CrudRepository;

public interface FlightRepository extends CrudRepository<FlightDTO,Long > {
}
