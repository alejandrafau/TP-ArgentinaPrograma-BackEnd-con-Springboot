/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.SpringBoot.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Collection;
//import java.util.Collection;
//import java.util.HashSet;
import java.util.List;
//import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


/**
 *
 * @author JGM
 */
@Entity
@Getter @Setter
public class Persona implements UserDetails  {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column (name="emp_id")
    
    private Long id;
    private String password;
    private String nombrecomp;
    private String descripcionb;
    private String mail;
    private Long telefono;
    private String descripcion;
    private String url;
    
    @Enumerated (EnumType.STRING)
    private Role rol;
    
    @OneToMany (cascade=CascadeType.ALL)
    @JoinColumn (name="fk_emp_id",referencedColumnName="emp_id")
    private List <Educacion> educacion;
     @OneToMany (cascade=CascadeType.ALL)
    @JoinColumn (name="fk_emp_id",referencedColumnName="emp_id")
     private List <Experiencia> experiencia;
      @OneToMany (cascade=CascadeType.ALL)
    @JoinColumn (name="fk_emp_id",referencedColumnName="emp_id")
     private List <Proyectos> proyectos;
    
     
    
    
    public Persona(){  
        
        
}
    
    public Persona (Long id, String nombrecomp,String descripcion, String descripcionb, String mail,String password, Long telefono, String direccion,String url, ArrayList experiencia,ArrayList educacion,ArrayList proyectos  ){
        //this.proyectos = new Hashset();
        this.educacion = new ArrayList();
        this.experiencia = new ArrayList();
        this.proyectos = new ArrayList();
        this.password=password;
        this.id=id;
        this.nombrecomp=nombrecomp;
        this.descripcionb=descripcionb;
        this.mail=mail;
        this.telefono=telefono;
        this.descripcion=descripcion;
        this.url=url;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
      return List.of(new SimpleGrantedAuthority(rol.name()));
    }

    @Override
    public String getUsername() {
        return getMail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
       return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

   

}