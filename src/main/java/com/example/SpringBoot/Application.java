package com.example.SpringBoot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
        
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
         registry.addMapping("/login")
                .allowedOrigins("http://localhost:4200")
                .allowedMethods("GET", "POST")
                .exposedHeaders("Access-Control-Allow-Origin")
                .maxAge(600);
         
          //registry.addMapping("/brindarDatos")
                //.allowedOrigins("http://localhost:4200")
                //.allowedMethods("GET", "POST")
                //.exposedHeaders("Access-Control-Allow-Origin")
                //.maxAge(600); 
    }
    
}
}



