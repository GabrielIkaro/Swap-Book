package com.swapp.swapp.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
public class MySecurityConfig{
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
        .authorizeRequests()
        .antMatchers("/newbook", "/perfil", "/estante", "/user", "/geo", "/pesquisa").authenticated()
        .antMatchers("/login", "/register").permitAll()
        .and()
        .formLogin(form ->form
                    .loginPage("/login")
                    .permitAll()  
                    .defaultSuccessUrl("/perfil", true)
        )
        .csrf().disable();

        return http.build();
    }

    @Bean
    public org.springframework.security.crypto.password.PasswordEncoder PasswordEncoder(){
        return new BCryptPasswordEncoder();

    }

}
