package com.swapp.swapp.service;

import com.swapp.swapp.repository.CategoriaRepository;
import com.swapp.swapp.model.CategoriaModel;

public class CategoriaService{
    private final CategoriaRepository categoriarepository;

    public CategoriaService(CategoriaRepository categoriarepository){
        this.categoriarepository = categoriarepository;
    }

    public CategoriaModel CategoriaFactory(String name){
        if(categoriarepository.existsByNome(name)){
            return categoriarepository.findByNome(name).get();
        }else{
            CategoriaModel l = new CategoriaModel();
            l.setNome(name);
            return l;
        }
    }
}
