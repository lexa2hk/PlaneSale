package com.smolnikov.planesale.AirportLogic.Aircraft.Airplane;


import com.smolnikov.planesale.AirportLogic.Aircraft.Aircraft;
import com.smolnikov.planesale.AirportLogic.Aircraft.Interface.AircraftOptions;
import com.smolnikov.planesale.AirportLogic.logger.logger;

import java.io.IOException;
import java.io.Serializable;


public class Airplane extends Aircraft implements AircraftOptions, logger, Serializable {
    public Airplane(String status, String type, String model) {
        super(status, type, model);
    }

    @Override
    public String parking() throws IOException {
        this.status=Status.PARKING;
        String message="Status of "+model+" has switched to: "+status;
        logger.log(message);
        return message;
    }

    @Override
    public String steering() throws IOException {
        this.status=Status.STEERING;
        String message="Status of "+model+" has switched to: "+status;
        logger.log(message);
        return message;
    }

    @Override
    public String stopOnLane() throws IOException {
        this.status=Status.STOP_ON_LANE;
        String message="Status of "+model+" has switched to: "+status;
        logger.log(message);
        return message;
    }

    @Override
    public String acceleration() throws IOException {
        this.status=Status.ACCELERATION;
        String message="Status of "+model+" has switched to: "+status;
        logger.log(message);
        return message;
    }

    @Override
    public String takeoff() throws IOException {
        this.status=Status.TAKEOFF;
        String message="Status of "+model+" has switched to: "+status;
        logger.log(message);
        return message;
    }

    @Override
    public String flight() throws IOException {
        this.status=Status.FLIGHT;
        String message="Status of "+model+" has switched to: "+status;
        logger.log(message);
        return message;
    }

    @Override
    public String landing() throws IOException {
        this.status=Status.LANDING;
        String message="Status of "+model+" has switched to: "+status;
        logger.log(message);
        return message;
    }

    @Override
    public String getInfo() throws IOException {
        String message="Airplane info: "+status+" "+type+" "+model;
        logger.log(message);
        return message;
    }
}
