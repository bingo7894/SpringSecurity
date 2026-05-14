package com.example.spring_security.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @GetMapping("/find")
    public ResponseEntity<String> getUser(){
        return ResponseEntity.ok("Hello World");
    }

    @PostMapping("/say-name")
    public ResponseEntity<String> SayName(@RequestBody String name){
        return ResponseEntity.ok(name);
    }

}
