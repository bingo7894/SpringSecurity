package com.example.spring_security.service;

import com.example.spring_security.dto.request.RegisterUserRequest;
import com.example.spring_security.dto.response.RegisterUserResponse;
import com.example.spring_security.entity.Users;
import com.example.spring_security.repository.UserDetailsRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserDetailsRepository userDetailsRepository;
    private final PasswordEncoder passwordEncoder;



    public UserService(UserDetailsRepository userDetailsRepository, PasswordEncoder passwordEncoder) {
        this.userDetailsRepository = userDetailsRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public RegisterUserResponse registerUser(RegisterUserRequest registerUserRequest){
        //TODO : check if user is already present
        if(userDetailsRepository.findByUsername(registerUserRequest.getUsername()).isPresent()){
            throw  new RuntimeException("User already exist");
        }
        //TODO : encode password in request
        Users users = new Users();
        users.setUsername(registerUserRequest.getUsername());
        users.setRole(registerUserRequest.getRole());
        users.setPassword(passwordEncoder.encode(registerUserRequest.getPassword()));

        //TODO : save user
        Users saveUser = userDetailsRepository.save(users);

        //TODO : User -> RegisterUserResponse
        return new RegisterUserResponse( saveUser.getId(),saveUser.getUsername(),saveUser.getRole().name());
    }
}
