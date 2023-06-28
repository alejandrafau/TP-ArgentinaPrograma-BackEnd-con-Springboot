/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.SpringBoot.security.config;

import com.example.SpringBoot.repository.PersonaInterface;
import java.util.function.Supplier;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class AppConfig {
    private final PersonaInterface repository;
   
    @Bean
   public UserDetailsService  userDetailsService(){
       return (String username) -> repository.findByMail(username)
               .orElseThrow();  
       }
   
   @Bean 
   public AuthenticationProvider authenticationProvider(){
       DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
       authProvider.setUserDetailsService (userDetailsService());
       authProvider.setPasswordEncoder (passwordEncoder());
       return authProvider;
       
   }
   
   @Bean
   public AuthenticationManager authenticationManager (AuthenticationConfiguration config) throws Exception {
       return config.getAuthenticationManager();
    
}
           
   @Bean
   public PasswordEncoder passwordEncoder(){
       return new BCryptPasswordEncoder();
       
       
   }
  
	}
   

