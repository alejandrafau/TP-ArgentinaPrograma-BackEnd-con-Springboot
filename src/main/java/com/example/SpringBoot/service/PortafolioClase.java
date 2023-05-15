/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.SpringBoot.service;

//import com.example.SpringBoot.model.Educacion;
//import com.example.SpringBoot.model.Experiencia;
import com.example.SpringBoot.model.Educacion;
import com.example.SpringBoot.model.Experiencia;
import com.example.SpringBoot.model.Persona;
import com.example.SpringBoot.model.Proyectos;
//import com.example.SpringBoot.model.Proyectos;
import com.example.SpringBoot.repository.EducacionInterface;
import com.example.SpringBoot.repository.ExperienciaInterface;
import com.example.SpringBoot.repository.PersonaInterface;
import com.example.SpringBoot.repository.ProyectosInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
//import static com.fasterxml.jackson.databind.cfg.CoercionInputShape.String;
//import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PortafolioClase implements PortafolioInterface {
    
    @Autowired
    public PersonaInterface persoRepo;
    public ExperienciaInterface experRepo;

    /**
     *
     */
    public EducacionInterface eduRepo;
    public ProyectosInterface proyRepo;
    
    
   

    @Override
    public List <Persona> brindarDatos( ) {
    return persoRepo.findAll();
    }

 
    @Override
    //problema con la instanciacion pero creo que va por ahí
    public void agregarPersona(Persona per) {
       persoRepo.save(per);
      
       
    }

    @Override
    public void modificarPersona(Persona per) {
      persoRepo.save(per);
      
    }
        
  
    }

