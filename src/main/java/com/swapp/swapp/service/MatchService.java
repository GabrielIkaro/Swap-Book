package com.swapp.swapp.service;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;

import com.swapp.swapp.model.Match;
import com.swapp.swapp.model.Users;
import com.swapp.swapp.repository.MatchRepository;

public class MatchService {

    @Autowired
    MatchRepository matchRepository;

    public List<Match> getAll(Users u){
        List<Match> list1 = matchRepository.findByUser1(u);
        List<Match> list2 = matchRepository.findByUser2(u);

        List<Match> newList = Stream.concat(list1.stream(), list2.stream()).toList();

        return newList;
    }
    
}
