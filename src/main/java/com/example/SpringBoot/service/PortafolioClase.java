/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.SpringBoot.service;


import com.example.SpringBoot.model.Persona;
import com.example.SpringBoot.repository.PersonaInterface;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class PortafolioClase implements PortafolioInterface {
    
    @Autowired
    private PersonaInterface persoRepo;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private AuthenticationManager authenticationManager;

   
    
   
    
   

    @Override
    public Optional<Persona> brindarDatos(String mail ) {
     
   return persoRepo.findByMail(mail);
    
  
       
    }

 
    @Override
    //problema con la instanciacion pero creo que va por ahí
  
    public void agregarPersona(Persona per) {
    
       per.setPassword(passwordEncoder.encode(per.getPassword()));
       persoRepo.save(per);
       
      
       
    }

    @Override
    public void modificarPersona(Persona per) {
      persoRepo.save(per);
      
    }

    @Override
    public void autenticarPersona(Persona per) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
        per.getMail(),
        per.getPassword())
        );
        persoRepo.findByMail(per.getMail())
        .orElseThrow();
         
      
        
    
                
    }
        
  
    }

