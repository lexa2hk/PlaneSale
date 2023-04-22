package com.smolnikov.planesale.Repository;

import com.smolnikov.planesale.Entity.AircraftEntity;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface AircraftRepo extends CrudRepository<AircraftEntity, Integer>, Serializable {
    AircraftEntity findByFlightcode(String flightcode);
}
