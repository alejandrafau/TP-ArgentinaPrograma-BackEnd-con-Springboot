/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.SpringBoot.security.config;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
//import io.jsonwebtoken.security.Keys;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import javax.crypto.SecretKey;
//import javax.crypto.SecretKey;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


@Service
public class JwtService {
    
 private static final SecretKey JWT_TOKEN = Keys.secretKeyFor(SignatureAlgorithm.HS256);
 //private static final String JWT_TOKEN = "o92AdERfg9YGjC48vaqeKusE/+B8isb8eDvjuOppcLc=";   

   
    
    String extractUsername(String token) {
       return extractClaim (token, Claims::getSubject);
   
    }
    
    private Date extractExpiration(String token){
return extractClaim(token, Claims::getExpiration);
}

private boolean isTokenExpired(String token){
return extractExpiration(token).before(new Date());
}
    
    public Boolean validateToken(String token, UserDetails userDetails) {
       
		final String username = extractUsername(token);
		return username.equals(userDetails.getUsername())&& (!isTokenExpired(token));
	
    }

    
   public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
   }
   
 public String generateToken(UserDetails userDetails) {
       return generateToken (new HashMap<>(),userDetails);
   }
 
 public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails)
{
    
 return Jwts.builder().setClaims(extraClaims)
                      .setSubject(userDetails.getUsername())
                      .setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000*60*60*24))
				.signWith(SignatureAlgorithm.HS256,JWT_TOKEN)
                                .compact();   
    
}
     
     
   
 
private Claims extractAllClaims (String token){
     
 return Jwts.parser().setSigningKey(JWT_TOKEN).parseClaimsJws(token).getBody();
    
}

    
//private static SecretKey getSigningKey() {
        //int minKeyLength = SignatureAlgorithm.HS512.getMinKeyLength();
       //byte[]keyBytes = new byte [minKeyLength/8];
       //SecureRandom secureRandom = new SecureRandom();
        //keyBytes=Decoders.BASE64.decode(JWT_SECRET);
        //secureRandom.nextBytes(keyBytes);
        //return Keys.hmacShaKeyFor(keyBytes);
    //}
    }



