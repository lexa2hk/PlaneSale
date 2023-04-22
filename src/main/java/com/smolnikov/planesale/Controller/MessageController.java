package com.smolnikov.planesale.Controller;

import com.smolnikov.planesale.AirportLogic.Application.Application;
import com.smolnikov.planesale.Service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    MessageService messageService;

    @Autowired
    Application application;

    @GetMapping("/getMessages")
    public ResponseEntity getMessages(){
        try {
            return ResponseEntity.ok(messageService.findAll());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping("/getLastMessage")
    public ResponseEntity getLastMessage(){
        try {
            return ResponseEntity.ok(messageService.getMessage("Last message"));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error");
        }
    }
}
