/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.SpringBoot.service;

//import com.example.SpringBoot.model.Educacion;
//import com.example.SpringBoot.model.Experiencia;
import com.example.SpringBoot.model.Persona;
import java.util.List;
//import com.example.SpringBoot.model.Proyectos;
//import java.util.List;


public interface PortafolioInterface {
    
   List <Persona> brindarDatos();
    //void modificarExperiencia();
    //void eliminarExperiencia();
    //void agregarExperiencia();
    //void modificarEducacion();
    //void eliminarEducacion();
    //void agregarEducacion();
    //void modificarProyectos();
    //void agregarProyectos();
    //void eliminarProyectos();
    void agregarPersona(Persona per);
    void modificarPersona (Persona per);
    
    
    
}
