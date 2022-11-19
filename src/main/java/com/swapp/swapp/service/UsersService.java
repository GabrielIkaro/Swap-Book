package com.swapp.swapp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.swapp.swapp.model.Users;
import com.swapp.swapp.repository.UsersRepository;

@Service
@Transactional
public class UsersService implements UserDetailsService{

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    @Lazy
    private PasswordEncoder passwordEncoder;


    @Transactional
    public String createUser(Users user){
        String message = "";
        if (usersRepository.existsByEmail(user.getEmail())){
            message += "Email já cadastrado.\r\n";
        }
        if (usersRepository.existsByLogin(user.getLogin())){
            message += "Usuário já existe.\r\n";
        }
        if (!user.getPassword().equals(user.getConfirm_password())){
            message += "Confirmação de Senha não é igual a Senha.";
        }

        if (message.isEmpty()){
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            usersRepository.save(user);
        }
        return message;
    }

    public List<Users> readUsers(){
        return usersRepository.findAll();
    }

    public Users authenticate(String login, String password){
        return usersRepository.findByLoginAndPassword(login, password).orElse(null);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = usersRepository.findByLogin(username)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found with login: " + username));
        return user;
    }

    
}
