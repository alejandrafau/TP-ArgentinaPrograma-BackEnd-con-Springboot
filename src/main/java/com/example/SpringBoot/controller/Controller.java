
package com.example.SpringBoot.controller;

//import org.springframework.web.bind.annotation.GetMapping;
import com.example.SpringBoot.model.Persona;
import com.example.SpringBoot.security.config.JwtService;
import com.example.SpringBoot.service.PortafolioClase;
//import com.example.SpringBoot.service.PortafolioClase;
import com.example.SpringBoot.service.PortafolioInterface;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import java.util.List;
import java.util.Optional;
//import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200")
@RestController
 
public class Controller {
    
    
    
 @Autowired
   private  JwtService jwtService; 
    
@Autowired
private PortafolioInterface PortServe ;



        //this.PortServe = new PortafolioClase ;


    
    @GetMapping("/brindarDatos")
            //@ResponseBody
       
        public Optional<Persona> brindarDatos(@RequestHeader("Authorization") String authorizationHeader){
        String token = authorizationHeader.substring(7);
        String subject = jwtService.extractClaim(token, Claims::getSubject);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Origin", "http://localhost:4200/portafolio");
       return PortServe.brindarDatos(subject);
         
    }   
        
   @PostMapping("/register")
   @ResponseBody
   public String agregarPersona(@RequestBody Persona per){
   PortServe.agregarPersona(per);
       return jwtService.generateToken(per);
          
   }
   
   @PostMapping("/login")
   
   public ResponseEntity<String> autenticarPersona(@RequestBody Persona per) {
    PortServe.autenticarPersona(per);
    String token = jwtService.generateToken(per);
     //HttpHeaders headers = new HttpHeaders();
     //headers.add("Authorization", "Bearer " + token);
    //headers.add("Access-Control-Allow-Origin", "http://localhost:4200");
    //headers.add("Access-Control-Allow-Credentials", "true");
     //return new ResponseEntity(headers, HttpStatus.OK);

        return ResponseEntity.ok().body("{\"token\": \"" + token + "\"}");
       
   }     

    // Create the response entity with the token and appropriate headers
    
}
    

   //@ResponseBody
   //public String autenticarPersona (@RequestBody Persona per){
  
   //return new ResponseEntity<(jwtService.generateToken(per), HttpStatus.OK);
   //return jwtService.generateToken(per);
         
   //}
   
       
   
    



