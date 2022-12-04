package com.swapp.swapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swapp.swapp.model.LinguaModel;
import com.swapp.swapp.repository.*;

@Service
public class LinguaService {

    @Autowired
    private LinguaRepository linguarepository;


    public LinguaModel LinguaFactory(String name){
        if(linguarepository.existsByNome(name)){
            return linguarepository.findTopByNome(name).get();
        }else{
            LinguaModel l = new LinguaModel();
            l.setNome(name);
            return l;
        }
    }

    public List<String> fingAllNames(String term){
        return linguarepository.findAllNomesByTerm(term);
    }
    
}
