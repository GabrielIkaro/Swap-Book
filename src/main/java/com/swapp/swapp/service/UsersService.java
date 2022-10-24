package com.swapp.swapp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swapp.swapp.model.Users;
import com.swapp.swapp.repository.UsersRepository;

@Service
public class UsersService{

    @Autowired
    private UsersRepository usersRepository;


    @Transactional
    public Users createUser(Users user){
        try {
            if (!usersRepository.existsByEmail(user.getEmail())){
                return usersRepository.save(user);
            }else {
                return null;
            }
        }catch (Exception e){
            throw e;
        }
    }

    public List<Users> readUsers(){
        return usersRepository.findAll();
    }

    public Users authenticate(String login, String password){
        return usersRepository.findByLoginAndPassword(login, password).orElse(null);
    }

    
}
