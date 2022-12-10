package com.swapp.swapp.service;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swapp.swapp.model.Books;
import com.swapp.swapp.model.Match;
import com.swapp.swapp.model.Users;
import com.swapp.swapp.repository.MatchRepository;

@Service
public class MatchService {

    @Autowired
    MatchRepository matchRepository;

    public List<Match> getAll(Users u){
        List<Match> list1 = matchRepository.findByUser1(u);
        List<Match> list2 = matchRepository.findByUser2(u);

        List<Match> newList = Stream.concat(list1.stream(), list2.stream()).toList();

        return newList;
    }

    public void saveMatch(Users u1, Users u2, Books b1, Books b2){
        Match match = new Match();
        match.setUser1(u1);
        match.setUser2(u2);
        match.setBook1(b1);
        match.setBook2(b2);

        matchRepository.save(match);

    }
    
}
