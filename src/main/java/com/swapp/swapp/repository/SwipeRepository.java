package com.swapp.swapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.swapp.swapp.model.*;

@Repository
public interface SwipeRepository extends JpaRepository<Swipe, Integer>{
    
}
