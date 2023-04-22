package com.smolnikov.planesale.AirportLogic.Aircraft.Interface;

import java.io.IOException;
import java.io.Serializable;

public interface AircraftOptions extends Serializable {
    String parking() throws IOException;
    String steering() throws IOException;
    String stopOnLane() throws IOException;
    String acceleration() throws IOException;
    String takeoff() throws IOException;
    String flight() throws IOException;
    String landing() throws IOException;
    String getInfo() throws IOException;
}
