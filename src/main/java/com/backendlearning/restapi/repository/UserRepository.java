package com.backendlearning.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.backendlearning.restapi.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}