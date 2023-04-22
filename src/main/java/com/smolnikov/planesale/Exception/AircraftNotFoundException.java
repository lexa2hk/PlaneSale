package com.smolnikov.planesale.Exception;

import java.io.Serializable;

public class AircraftNotFoundException extends Exception implements Serializable {
    public AircraftNotFoundException(String message) {
        super(message);
    }
}