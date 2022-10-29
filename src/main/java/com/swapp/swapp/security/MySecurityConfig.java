package com.swapp.swapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.swapp.swapp.service.UsersService;

@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    final UsersService userService;

    public MySecurityConfig(UsersService userService) {
        this.userService = userService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/newbook").authenticated()
            .antMatchers("/login", "/index", "/register").permitAll()
            .and()
            .formLogin()
            .permitAll()
            .and()
            .csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService)
            .passwordEncoder(PasswordEncoder());
    }

    @Bean
    public org.springframework.security.crypto.password.PasswordEncoder PasswordEncoder(){
        return new BCryptPasswordEncoder();

    }

}
