package com.example.spring_security.dto.request;

import com.example.spring_security.enums.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserRequest {

    private String username;
    private String password;
    private Role role;

}
