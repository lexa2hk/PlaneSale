package com.smolnikov.planesale.Controller;

import ch.qos.logback.core.model.Model;
//import com.example.task23.Dao.GametableDao;
//import com.example.task23.Dao.LeveltableDao;
//import com.example.task23.Entity.GametableEntity;
//import com.example.task23.Entity.LeveltableEntity;
//import com.example.task23.Entity.MyUser;
//import com.example.task23.Jmx.SchedulerMBean;
//import com.example.task23.services.GameService;
//import com.example.task23.services.LevelService;
//import com.example.task23.services.UserService;
import com.smolnikov.planesale.Entity.User;
import com.smolnikov.planesale.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/v1")
public class RestController {


//    TODO: fix stackoverflow error when getting all games and levels

    @Autowired
    UserService userService;



//    @GetMapping("/registration")
//    public String registration() {
//        return "reg";
//    }

    @GetMapping("/ping")
    public String ping() {
        return "Pong! You are authenticated user";
    }


}