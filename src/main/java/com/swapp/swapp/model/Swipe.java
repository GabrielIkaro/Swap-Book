package com.swapp.swapp.model;

import java.util.Date;

import javax.persistence.CascadeType;
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
@Table(name = "like_table")
public class Swipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    Users swiperUser;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "book_id")
    Books shownBook;
    
    Boolean liked;
    Date day;
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Users getSwiperUser() {
        return swiperUser;
    }
    public void setSwiperUser(Users swiperUser) {
        this.swiperUser = swiperUser;
    }
    public Books getShownBook() {
        return shownBook;
    }
    public void setShownBook(Books shownBook) {
        this.shownBook = shownBook;
    }
    public Boolean getLiked() {
        return liked;
    }
    public void setLiked(Boolean liked) {
        this.liked = liked;
    }
    public Date getDay() {
        return day;
    }
    public void setDay(Date day) {
        this.day = day;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((swiperUser == null) ? 0 : swiperUser.hashCode());
        result = prime * result + ((shownBook == null) ? 0 : shownBook.hashCode());
        result = prime * result + ((liked == null) ? 0 : liked.hashCode());
        result = prime * result + ((day == null) ? 0 : day.hashCode());
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
        Swipe other = (Swipe) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (swiperUser == null) {
            if (other.swiperUser != null)
                return false;
        } else if (!swiperUser.equals(other.swiperUser))
            return false;
        if (shownBook == null) {
            if (other.shownBook != null)
                return false;
        } else if (!shownBook.equals(other.shownBook))
            return false;
        if (liked == null) {
            if (other.liked != null)
                return false;
        } else if (!liked.equals(other.liked))
            return false;
        if (day == null) {
            if (other.day != null)
                return false;
        } else if (!day.equals(other.day))
            return false;
        return true;
    }

    
}
