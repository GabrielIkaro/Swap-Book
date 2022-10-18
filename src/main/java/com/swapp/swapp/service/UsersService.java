package com.swapp.swapp.service;

import org.springframework.stereotype.Service;

import com.swapp.swapp.model.Users;
import com.swapp.swapp.repository.UsersRepository;

@Service
public class UsersService{

    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    public Users registerUser(String login, String password, String email){
        if(login!=null && password !=null){
            Users users = new Users();
            users.setPassword(password);
            users.setLogin(login);
            users.setEmail(email);
            return usersRepository.save(users);
        }else{
            return null;
        }
    }

    public Users authenticate(String login, String password){
        return usersRepository.findByLoginAndPassword(login, password).orElse(null);
    }
    
}
