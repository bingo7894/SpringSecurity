package com.example.spring_security.dto.request;

import lombok.*;

@Getter
@Setter
public class AuthRequest {

    private String username;
    private String password;

}
