package com.example.spring_security.service;

import com.example.spring_security.entity.Users;
import com.example.spring_security.enums.Role;
import com.example.spring_security.repository.UserDetailsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AdminUserInitialization {

    @Bean
    public CommandLineRunner createAdminUser(UserDetailsRepository userDetailsRepository, PasswordEncoder passwordEncoder){
        return args -> {
            if(userDetailsRepository.findByUsername("admin").isEmpty()){
                Users admin = new Users();
                admin.setUsername("admin");
                admin.setPassword(passwordEncoder.encode("admin1234"));
                admin.setRole(Role.ADMIN);

                userDetailsRepository.save(admin);
                System.out.println("Default admin user created!");
            }
            if(userDetailsRepository.findByUsername("user").isEmpty()){
                Users admin = new Users();
                admin.setUsername("user");
                admin.setPassword(passwordEncoder.encode("user1234"));
                admin.setRole(Role.USER);

                userDetailsRepository.save(admin);
                System.out.println("Default User user created!");
            }
        };
    }

}
