package com.swapp.swapp.model;

import java.time.Year;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "books_table")
public class Books {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "editora.id")
    private EditoraModel editora;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lingua.id")
    private LinguaModel lingua;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria.id")
    private CategoriaModel categoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user.id")
    private Users user;

    String isbn;
    String titulo;
    Boolean status;
    Year publicacao;
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public EditoraModel getEditora() {
        return editora;
    }
    public void setEditora(EditoraModel editora) {
        this.editora = editora;
    }
    public LinguaModel getLingua() {
        return lingua;
    }
    public void setLingua(LinguaModel lingua) {
        this.lingua = lingua;
    }
    public Users getUser() {
        return user;
    }
    public void setUser(Users user) {
        this.user = user;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public Boolean getStatus() {
        return status;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }
    public Year getPublicacao() {
        return publicacao;
    }
    public void setPublicacao(Year publicacao) {
        this.publicacao = publicacao;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((editora == null) ? 0 : editora.hashCode());
        result = prime * result + ((lingua == null) ? 0 : lingua.hashCode());
        result = prime * result + ((user == null) ? 0 : user.hashCode());
        result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
        result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result + ((publicacao == null) ? 0 : publicacao.hashCode());
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
        Books other = (Books) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (editora == null) {
            if (other.editora != null)
                return false;
        } else if (!editora.equals(other.editora))
            return false;
        if (lingua == null) {
            if (other.lingua != null)
                return false;
        } else if (!lingua.equals(other.lingua))
            return false;
        if (user == null) {
            if (other.user != null)
                return false;
        } else if (!user.equals(other.user))
            return false;
        if (isbn == null) {
            if (other.isbn != null)
                return false;
        } else if (!isbn.equals(other.isbn))
            return false;
        if (titulo == null) {
            if (other.titulo != null)
                return false;
        } else if (!titulo.equals(other.titulo))
            return false;
        if (status == null) {
            if (other.status != null)
                return false;
        } else if (!status.equals(other.status))
            return false;
        if (publicacao == null) {
            if (other.publicacao != null)
                return false;
        } else if (!publicacao.equals(other.publicacao))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Books [id=" + id + ", editora=" + editora + ", lingua=" + lingua + ", user=" + user + ", isbn=" + isbn
                + ", titulo=" + titulo + ", status=" + status + ", publicacao=" + publicacao + "]";
    }

    
    
}
