package com.smolnikov.planesale.AirportLogic.EventGenerator;


import com.smolnikov.planesale.AirportLogic.Aircraft.Airplane.Airplane;
import com.smolnikov.planesale.AirportLogic.Aircraft.Helicopter.Helicopter;
import com.smolnikov.planesale.AirportLogic.Terminal.Terminal;
import com.smolnikov.planesale.Exception.AircraftAlreadyExists;
import com.smolnikov.planesale.Service.AircraftService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

@Component
public class EventGenerator implements Serializable {
//    AirportDBmySQL database;
    @Autowired
    Terminal terminal;

    protected final double _plane_const = 0.3;
    //base of all possible props for random generation
    protected String[] _models_plane = {"BOEING 737-800", "BOEING 777-300", "AIRBUS A320-200", "AIRBUS A330-200", "AIRBUS A350-900", "AIRBUS A380-800", "SSJ-100", "Cessna 172", "Cessna 150"};
    protected String[] _models_helicopter = {"MI-8", "MI-24", "MI-26", "MI-28"};
    protected String[] _cities = {"Omsk", "Moscow", "Kazan", "Krasnodar", "Krasnoyarsk", "Novosibirsk", "Vladivostok", "Yekaterinburg", "Samara", "Rostov-on-Don", "Ufa", "Chelyabinsk", "Perm", "Khabarovsk", "Voronezh", "Nizhny Novgorod", "Volgograd", "Saratov", "Tyumen", "Izhevsk", "Kemerovo", "Orenburg", "Barnaul", "Tolyatti", "Ulan-Ude", "Irkutsk", "Yaroslavl", "Tomsk", "Kirov", "Kazan", "Krasnodar", "Krasnoyarsk", "Novosibirsk", "Vladivostok", "Yekaterinburg", "Samara", "Rostov-on-Don", "Ufa", "Chelyabinsk", "Perm", "Khabarovsk", "Voronezh", "Nizhny Novgorod", "Volgograd", "Saratov", "Tyumen", "Izhevsk", "Kemerovo", "Orenburg", "Barnaul", "Tolyatti", "Ulan-Ude", "Irkutsk", "Yaroslavl", "Tomsk", "Kirov"};
    protected String[] _status = {"PARKING", "STEERING", "STOP_ON_LANE", "ACCELERATION", "TAKEOFF", "FLIGHT", "LANDING"};
    protected String[] _status_spawn = {"FLIGHT", "PARKING"};
    protected String[] _event_type = {"LANDING","TAKEOFF"};

    public EventGenerator(){

    }

    public void createEventAirplane(String flightCode, String eventType, String city, String status, String type, String model) throws AircraftAlreadyExists{

        Airplane plane=new Airplane(status, type, model);
        terminal.addEvent(flightCode,eventType,city,plane);
        //вызвать анимацию на полосе
    }

    public void createEventHelicopter(String flightCode, String eventType, String city, String status, String type, String model) throws AircraftAlreadyExists {

        Helicopter heli=new Helicopter(status, type, model);
        terminal.addEvent(flightCode,eventType,city,heli);
        //вызвать анимацию на полосе
    }

    private String createFlightCode(){
        Random r = new Random();
        String c1 = String.valueOf((char) (r.nextInt(26) + 'A'));
        String c2 = String.valueOf((char) (r.nextInt(26)+ 'A'));
        String n1 = String.valueOf(r.nextInt(10));
        String n2 = String.valueOf(r.nextInt(10));
        String n3 = String.valueOf(r.nextInt(10));
        String n4 = String.valueOf(r.nextInt(10));
//        System.out.println(c1+c2+n1+n2+n3+n4);
        return c1+c2+n1+n2+n3+n4;
    }

    public Boolean tryCreateRandomEvent(ArrayDeque<String> eventQueue,Integer freePlace)  throws AircraftAlreadyExists{

        if(freePlace==null){
            return false;
        }
        double random = Math.random();
        if (random < _plane_const) {
            String flightCode=createFlightCode();
            String eventType=_event_type[(int) (Math.random() * _event_type.length)];
            String statusSpawn;
            if (eventType=="LANDING"){
               statusSpawn="FLIGHT";
            }
            else{
                statusSpawn="PARKING";
            }
            if (Math.random() > 0) {
                createEventAirplane(flightCode,
                        eventType,
                        _cities[(int) (Math.random() * _cities.length)],
                        statusSpawn,
                        "AIRPLANE",
                        _models_plane[(int) (Math.random() * _models_plane.length)]
                );
            } else {
                createEventHelicopter(flightCode,
                        eventType,
                        _cities[(int) (Math.random() * _cities.length)],
                        statusSpawn,
                        "HELICOPTER",
                        _models_helicopter[(int) (Math.random() * _models_helicopter.length)]
                );
            }
            eventQueue.offerLast(flightCode);
           return true;
        }
        return false;
    }

}
