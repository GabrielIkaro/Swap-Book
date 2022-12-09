package com.swapp.swapp.model;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

@Entity
@Table(name = "match_table")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    @ManyToOne
    @JoinColumn(name="user1")
    Users user1;
    @ManyToOne
    @JoinColumn(name="user2")
    Users user2;

    @ManyToOne
    @JoinColumn(name="book1")
    Books book1;
    @ManyToOne
    @JoinColumn(name="book2")
    Books book2;

    public Users getOtherUser(Users u){

        if(u == user1){
            return this.user2;
        }
        else{
            return this.user1;
        }
    }

    public Books getOtherBook(Users u){
        if(u == user1){
            return this.book2;
        }
        else{
            return this.book1;
        }
    }

    public Books getMyBook(Users u){
        if(u == user1){
            return this.book1;
        }
        else{
            return this.book2;
        }
    }

    public Users getUser1() {
        return user1;
    }
    public void setUser1(Users user1) {
        this.user1 = user1;
    }
    public Users getUser2() {
        return user2;
    }
    public void setUser2(Users user2) {
        this.user2 = user2;
    }
    public Books getBook1() {
        return book1;
    }
    public void setBook1(Books book1) {
        this.book1 = book1;
    }
    public Books getBook2() {
        return book2;
    }
    public void setBook2(Books book2) {
        this.book2 = book2;
    }
    
    
}
