package com.swapp.swapp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "editora_table")
public class EditoraModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String nome;

    @OneToMany(mappedBy="editora")
    private List<Books> bookslist = new ArrayList<Books>();

    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((bookslist == null) ? 0 : bookslist.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        EditoraModel other = (EditoraModel) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (bookslist == null) {
            if (other.bookslist != null)
                return false;
        } else if (!bookslist.equals(other.bookslist))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "EditoraModel [id=" + id + ", nome=" + nome + ", bookslist=" + bookslist + "]";
    }

    public List<Books> getBookslist() {
        return bookslist;
    }

    public void setBookslist(List<Books> bookslist) {
        this.bookslist = bookslist;
    }
    
    
}
