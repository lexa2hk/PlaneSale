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
import com.smolnikov.planesale.Auth.JwtService;
import com.smolnikov.planesale.Entity.User;
import com.smolnikov.planesale.Response.CartRequest;
import com.smolnikov.planesale.Response.CartResponse;
import com.smolnikov.planesale.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/v1")
public class RestController {

    @Autowired
    JwtService jwtService;

    @Autowired
    UserService userService;


    //    TODO: cart:remove,order
    @GetMapping("/ping")
    public String ping() {
        return "Pong! You are authenticated user";
    }



    @PostMapping("/addToCart")
    public String addToCart(@RequestBody CartRequest cartRequest) {
        return userService.addToCart(cartRequest);
    }

    @GetMapping("/getCart")
    public List<CartResponse> getCart(@RequestHeader("Authorization") String bearerToken) {
//        jwtService.extractUsername(bearerToken);
        return userService.getCart(jwtService.extractUsername(bearerToken.split(" ")[1]));
    }

    @PostMapping("/clearCart")
    public String clearCart(@RequestHeader("Authorization") String bearerToken) {
        return userService.clearCart(jwtService.extractUsername(bearerToken.split(" ")[1]));
    }

    @PostMapping("/removeFromCart")
    public String removeFromCart(@RequestHeader("Authorization") String bearerToken, @RequestBody String flightCode) {
        return userService.removeFromCart(jwtService.extractUsername(bearerToken.split(" ")[1]), flightCode);
    }

    @PostMapping("/order")
    public String order(@RequestHeader("Authorization") String bearerToken) {
        return userService.order(jwtService.extractUsername(bearerToken.split(" ")[1]));
    }




}
