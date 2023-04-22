package com.smolnikov.planesale.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Data
public class AircraftEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String type;
    private String city;
    private String time;

    private Date plannedtime;
    private String status;
    private String aircrafttype;
    private String aircraftmodel;
    //parking section
    private Integer parkingplace;

    //status section
    private String flightcode;

    private String currentstatus;



}
