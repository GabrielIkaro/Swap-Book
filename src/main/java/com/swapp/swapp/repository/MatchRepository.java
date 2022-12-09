package com.swapp.swapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.swapp.swapp.model.*;

@Repository
public interface MatchRepository extends JpaRepository<Match, Integer> {

    List<Match> findAll();

    List<Match> findByUser1(Users user1);

    List<Match> findByUser2(Users user2);
}
