package com.swapp.swapp.service;

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
}
