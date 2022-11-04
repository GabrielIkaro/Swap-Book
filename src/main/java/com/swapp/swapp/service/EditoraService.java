package com.swapp.swapp.service;

import com.swapp.swapp.model.EditoraModel;
import com.swapp.swapp.repository.EditoraRepository;

public class EditoraService {
    private final EditoraRepository editorarepository;

    public EditoraService(EditoraRepository editorarepository){
        this.editorarepository = editorarepository;
    }

    public EditoraModel EditoraFactory(String name){
        if(editorarepository.existsByNome(name)){
            return editorarepository.findByNome(name).get();
        }else{
            EditoraModel l = new EditoraModel();
            l.setNome(name);
            return l;
        }
    }
}
