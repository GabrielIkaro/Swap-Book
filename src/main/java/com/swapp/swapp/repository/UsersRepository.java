package com.swapp.swapp.repository;

import com.swapp.swapp.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer>{
    
    Optional<Users> findByLoginAndPassword(String login, String password);
}