package com.smolnikov.planesale.Controller;

import com.smolnikov.planesale.Service.AircraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@ResponseBody
@RequestMapping("/api/v1/table")
public class openDataController {

    @Autowired
    private AircraftService aircraftService;


    @GetMapping("/getFlights")
    public String getFlights() {
//        return "Pong! You are authenticated user";
        return aircraftService.getFlights();
    }

}
