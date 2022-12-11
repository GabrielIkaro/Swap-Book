package com.swapp.swapp.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "users_table")
public class Users implements UserDetails{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @NotEmpty(message="User login cannot be empty.")
    String login;
    @NotEmpty(message="User password cannot be empty.")
    String password;

    String confirm_password;
    @NotEmpty(message="User email cannot be empty.")
    String email;

    @OneToMany(mappedBy="user")
    private List<Books> bookslist = new ArrayList<>();

    @OneToMany(mappedBy="swiperUser")
    private List<Swipe> swipelist = new ArrayList<>();

    @Column(name="user_longi")
    private double longi;
    @Column(name="user_lat")
    private double lat;
    @Column(name="user_max")
    private double max_dis = 50;

    private String zip;

    

    
    
    
    public double getLongi() {
        return longi;
    }
    public void setLongi(double longi) {
        this.longi = longi;
    }
    public double getLat() {
        return lat;
    }
    public void setLat(double lat) {
        this.lat = lat;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((login == null) ? 0 : login.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((confirm_password == null) ? 0 : confirm_password.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((bookslist == null) ? 0 : bookslist.hashCode());
        result = prime * result + ((swipelist == null) ? 0 : swipelist.hashCode());
        long temp;
        temp = Double.doubleToLongBits(longi);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(lat);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(max_dis);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((zip == null) ? 0 : zip.hashCode());
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
        Users other = (Users) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (login == null) {
            if (other.login != null)
                return false;
        } else if (!login.equals(other.login))
            return false;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        if (confirm_password == null) {
            if (other.confirm_password != null)
                return false;
        } else if (!confirm_password.equals(other.confirm_password))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (bookslist == null) {
            if (other.bookslist != null)
                return false;
        } else if (!bookslist.equals(other.bookslist))
            return false;
        if (swipelist == null) {
            if (other.swipelist != null)
                return false;
        } else if (!swipelist.equals(other.swipelist))
            return false;
        if (Double.doubleToLongBits(longi) != Double.doubleToLongBits(other.longi))
            return false;
        if (Double.doubleToLongBits(lat) != Double.doubleToLongBits(other.lat))
            return false;
        if (Double.doubleToLongBits(max_dis) != Double.doubleToLongBits(other.max_dis))
            return false;
        if (zip == null) {
            if (other.zip != null)
                return false;
        } else if (!zip.equals(other.zip))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", login=" + login + ", email=" + email + "]";
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public String getUsername() {
        return this.getLogin();
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }
    public List<Books> getBookslist() {
        return bookslist;
    }
    public int getBookNumbers(){
        return bookslist.size();
    }
    public void setBookslist(List<Books> bookslist) {
        this.bookslist = bookslist;
    }
    public String getConfirm_password() {
        return confirm_password;
    }
    public void setConfirm_password(String confirm_password) {
        this.confirm_password = confirm_password;
    }
    public List<Swipe> getSwipelist() {
        return swipelist;
    }
    public void setSwipelist(List<Swipe> swipelist) {
        this.swipelist = swipelist;
    }
    public double getMax_dis() {
        return max_dis;
    }
    public void setMax_dis(double max_dis) {
        this.max_dis = max_dis;
    }
    public String getZip() {
        return zip;
    }
    public void setZip(String zip) {
        this.zip = zip;
    }


    
}
