package com.smolnikov.planesale.AirportLogic.Application;


import com.smolnikov.planesale.AirportLogic.EventGenerator.EventGenerator;
import com.smolnikov.planesale.AirportLogic.Terminal.Terminal;
import com.smolnikov.planesale.Exception.AircraftAlreadyExists;
import com.smolnikov.planesale.Service.AircraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

import static java.lang.Thread.sleep;

@Service
public class Application {
    @Autowired
    private AircraftService aircraftService;

//    private AirportDBmySQL db;

    @Autowired
    private Terminal terminal;

    @Autowired
    private EventGenerator gen;

    private ArrayDeque<String> eventQueue;

    @Autowired
    public Application(AircraftService aircraftService) {
        aircraftService.eraseAll();
        this.aircraftService = aircraftService;
//        this.terminal=new Terminal();
        this.gen=new EventGenerator();
        this.eventQueue=new ArrayDeque<>();
    }

    @Scheduled(fixedRate = 100)
    public void createEvent() throws AircraftAlreadyExists {
        gen.tryCreateRandomEvent(eventQueue, aircraftService.findFreeParkingPlace());
    }

    @Scheduled(fixedRate = 1000)
    public void processEvent() throws IOException {
        terminal.handleEvent(eventQueue);
    }


}
