package com.example.spring_security.repository;

import com.example.spring_security.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDetailsRepository extends JpaRepository<Users,Long> {

    Optional<Users> findByUsername(String username);

}
