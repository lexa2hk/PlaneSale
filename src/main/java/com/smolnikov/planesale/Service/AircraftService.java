package com.smolnikov.planesale.Service;


import com.smolnikov.planesale.Entity.AircraftEntity;
import com.smolnikov.planesale.Exception.AircraftAlreadyExists;
import com.smolnikov.planesale.Exception.AircraftNotFoundException;
import com.smolnikov.planesale.Repository.AircraftRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.*;

@Service
public class AircraftService implements Serializable {

    @Autowired
    private AircraftRepo aircraftRepo;

    HashMap<Integer, Boolean> parkingMap = new HashMap<Integer, Boolean>();

    Comparator<AircraftEntity> comparator = new Comparator<AircraftEntity>() {
        @Override
        public int compare(AircraftEntity o1, AircraftEntity o2) {
            return o1.getFlightcode().compareTo(o2.getFlightcode());
        }
    };

    public AircraftService() {
        for(int i=0;i<26;i++) {
            parkingMap.put(i, false);
        }
    }

    public AircraftEntity addAircraft(AircraftEntity aircraftEntity) throws AircraftAlreadyExists {
        if(aircraftRepo.findByFlightcode(aircraftEntity.getFlightcode()) != null){
            throw new AircraftAlreadyExists("Aircraft with this number already exists");
        }
        return aircraftRepo.save(aircraftEntity);
    }


    public Iterable<AircraftEntity> findAll() throws AircraftNotFoundException {
        if(aircraftRepo.findAll() == null){
            throw new AircraftNotFoundException("No aircrafts found");
        }else{
            return aircraftRepo.findAll();
        }
    }


    public Integer findFreeParkingPlace() {
        return parkingMap.entrySet().stream()
                .filter(entry -> entry.getValue().equals(false))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }

    public Integer getTableSize(){
        return parkingMap.size();
    }

    public Integer claimParkingPlace(Integer parkingPlace) {
        parkingMap.put(parkingPlace, true);
        return parkingPlace;
    }

    public Integer freeParkingPlace(Integer parkingPlace) {
        parkingMap.put(parkingPlace, false);
        return parkingPlace;
    }
    public void eraseAll() {
        aircraftRepo.deleteAll();
    }

    public String getFlights() {
        //return flightcodes
        List<AircraftEntity> list = new ArrayList<>();
        aircraftRepo.findAll().forEach(list::add);
        return list.stream().map(AircraftEntity::getFlightcode).toList().toString();
    }
}
