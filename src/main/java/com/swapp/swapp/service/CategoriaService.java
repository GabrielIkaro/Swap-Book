package com.swapp.swapp.service;

import com.swapp.swapp.repository.CategoriaRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swapp.swapp.model.CategoriaModel;

@Service
public class CategoriaService{
    @Autowired
    private CategoriaRepository categoriarepository;


    public CategoriaModel CategoriaFactory(String name){
        if(categoriarepository.existsByNome(name)){
            return categoriarepository.findTopByNome(name).get();
        }else{
            CategoriaModel l = new CategoriaModel();
            l.setNome(name);
            return l;
        }
    }

    public List<String> findAllNames(String term){
        return categoriarepository.findAllNomesByTerm(term);
    }
}
