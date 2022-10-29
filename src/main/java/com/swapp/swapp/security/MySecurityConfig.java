package com.swapp.swapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.swapp.swapp.service.UsersService;

@Configuration
public class MySecurityConfig{
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
        .authorizeRequests()
        .antMatchers("/newbook", "/index").authenticated()
        .antMatchers("/login", "/register").permitAll()
        .and()
        .formLogin(form ->form
                    .loginPage("/login")
                    .permitAll()  
                    .defaultSuccessUrl("/newbook", true)
        )
        .csrf().disable();

        return http.build();
    }

    @Bean
    public org.springframework.security.crypto.password.PasswordEncoder PasswordEncoder(){
        return new BCryptPasswordEncoder();

    }

}
