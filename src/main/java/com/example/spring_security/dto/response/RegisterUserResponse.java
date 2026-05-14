package com.example.spring_security.dto.response;

import com.example.spring_security.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RegisterUserResponse {

    private Long id;
    private String username;
    private String role;

}
