package com.smolnikov.planesale.Controller;

import com.smolnikov.planesale.AirportLogic.Application.Application;
import com.smolnikov.planesale.Entity.AircraftEntity;
import com.smolnikov.planesale.Service.AircraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@RestController
@RequestMapping("/aircraft")
public class AircraftController implements Serializable {

    @Autowired
    private AircraftService aircraftService;

    @Autowired
    private Application application;

    @PostMapping
    public ResponseEntity addAircraft(@RequestBody AircraftEntity aircraftEntity){
        try {
            aircraftService.addAircraft(aircraftEntity);
            return ResponseEntity.ok("Added");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/addRandom")
    public ResponseEntity addRandomAircraft(){
        try {
            application.createEvent();
            return ResponseEntity.ok("Added event");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @GetMapping("/findFreeParkingPlace")
    public ResponseEntity findFreeParkingPlace(){
        try {
            return ResponseEntity.ok(aircraftService.findFreeParkingPlace());
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity getAllAircraft(){
        try {
            return ResponseEntity.ok(aircraftService.findAll());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error");
        }
    }


    @GetMapping("/ping")
    public ResponseEntity ping(){
        try {
            return ResponseEntity.ok("Live");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Server is down");
        }
    }
}
