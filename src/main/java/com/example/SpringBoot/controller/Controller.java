
package com.example.SpringBoot.controller;

//import org.springframework.web.bind.annotation.GetMapping;
import com.example.SpringBoot.model.Persona;
//import com.example.SpringBoot.service.PortafolioClase;
import com.example.SpringBoot.service.PortafolioInterface;
import java.util.List;
//import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class Controller {
    
@Autowired
private PortafolioInterface PortServe ;

        //this.PortServe = new PortafolioClase ;
@CrossOrigin
        (origins = "http://localhost:4200")
    @GetMapping("/ver/persona")
            @ResponseBody
        public List <Persona> brindarDatos(){
        return PortServe.brindarDatos();
    }   
        
   @PostMapping("/sumar/persona")
   public void agregarPersona(@RequestBody Persona per){
       PortServe.agregarPersona(per);
       
   }
    
}


