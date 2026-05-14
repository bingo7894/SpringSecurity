package com.example.spring_security.controller;

import com.example.spring_security.dto.request.RegisterUserRequest;
import com.example.spring_security.dto.response.RegisterUserResponse;
import com.example.spring_security.enums.Role;
import com.example.spring_security.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterUserResponse> registerUser(@RequestBody RegisterUserRequest registerUserRequest){
        registerUserRequest.setRole(Role.USER);
        RegisterUserResponse userResponse = userService.registerUser(registerUserRequest);
        return ResponseEntity.ok(userResponse);
    }

    @PreAuthorize("hasAuthority('USER_WRITE')")
    @PostMapping("/admin/register")
    public ResponseEntity<RegisterUserResponse> registerUserByAdmin(@RequestBody RegisterUserRequest registerUserRequest){
        RegisterUserResponse userResponse = userService.registerUser(registerUserRequest);
        return ResponseEntity.ok(userResponse);
    }

}
