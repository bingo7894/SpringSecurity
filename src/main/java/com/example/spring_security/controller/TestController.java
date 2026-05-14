package com.example.spring_security.controller;

import com.example.spring_security.entity.Users;
import com.example.spring_security.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @PreAuthorize("hasAuthority('USER_READ')")
    @GetMapping("/find")
    public ResponseEntity<String> getUser(){
        return ResponseEntity.ok("Hello World");
    }

    @PreAuthorize("hasAuthority('USER_WRITE')")
    @PostMapping("/say-name")
    public ResponseEntity<String> SayName(@RequestBody String name){
        return ResponseEntity.ok(name);
    }


    @PostAuthorize("returnObject.username == authentication.name")
    @PostMapping("/check-me/{id}")
    public Users getMe(@PathVariable Long id){
        return userDetailsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Log not found"));
    }
}
