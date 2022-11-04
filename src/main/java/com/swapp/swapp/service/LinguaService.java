package com.swapp.swapp.service;

import org.springframework.stereotype.Service;

import com.swapp.swapp.model.LinguaModel;
import com.swapp.swapp.repository.*;

@Service
public class LinguaService {

    private final LinguaRepository linguarepository;

    public LinguaService(LinguaRepository linguarepository){
        this.linguarepository = linguarepository;
    }

    public LinguaModel LinguaFactory(String name){
        if(linguarepository.existsByNome(name)){
            return linguarepository.findByNome(name).get();
        }else{
            LinguaModel l = new LinguaModel();
            l.setNome(name);
            return l;
        }
    }
    
}
