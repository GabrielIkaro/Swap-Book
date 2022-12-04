package com.swapp.swapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swapp.swapp.model.EditoraModel;
import com.swapp.swapp.repository.EditoraRepository;

@Service
public class EditoraService {

    @Autowired
    private EditoraRepository editorarepository;

    public EditoraModel EditoraFactory(String name){
        if(editorarepository.existsByNome(name)){
            return editorarepository.findTopByNome(name).get();
        }else{
            EditoraModel l = new EditoraModel();
            l.setNome(name);
            return l;
        }
    }

    public List<String> findAllNomes(String term){
        return editorarepository.findAllNomesByTerm(term);
    }
}
