/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.SpringBoot.repository;

import com.example.SpringBoot.model.Persona;
//import java.util.List;
//import java.util.Optional;
//import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JGM
 */
@Repository
public interface PersonaInterface extends JpaRepository <Persona,Long>{   
//Persona findByid(Long id);
    
   
    
}
