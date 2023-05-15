package com.example.SpringBoot.model;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author JGM
 */
@Entity
@Getter @Setter
public class Proyectos {
    
     @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    private Long id;
    private String titulo;
    private String fechai;
    private String fechaf;
    private String descripcion;
    //@ManyToOne (cascade=CascadeType.ALL)
     //@JoinColumn (name="persona_id", referencedColumnName="id")
    //private Persona persona;
   
    public Proyectos(){  
}
    
    public Proyectos (Long id, String titulo, String fechai, String fechaf,String descripcion){
        
    
        this.id=id;
        this.titulo=titulo;
        this.fechai=fechai;
        this.fechaf=fechaf;
        this.descripcion=descripcion;
    }
}