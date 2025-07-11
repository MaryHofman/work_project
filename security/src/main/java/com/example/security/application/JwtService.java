package com.example.security.application;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.spec.SecretKeySpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.security.infrastructure.repository.jpa.BankUserJpaRepositoryImpl;
import com.example.security.infrastructure.repository.jpa.entity.BankUsersEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.lang.Arrays;

@Service
public class JwtService {

    private final BankUserJpaRepositoryImpl userRepository;
    
    @Autowired
    public JwtService(BankUserJpaRepositoryImpl userRepository) {
        this.userRepository = userRepository;
    }

    String securityAccess = "jdflajsdlfajdfajskdflajsdkfaskdjflasdkjfasdjfalsdfldasfjladsfj";
    String securityRefresh = "dhjlfajsdfhlajdkfhlasdkjfhlasfjkdhalsdfkjadlsfkjadfhldjaflajfdh";

    public String generateAccessToken(BankUsersEntity userDetails){
        String email = userDetails.getLogin();  
        System.out.println("Email   "+email);
        String token = generateToken(securityAccess, new HashMap<String, Object>(), userDetails.getLastName(), email, Integer.MAX_VALUE);
        return token;
    }
    
    public String generateRefreshToken(BankUsersEntity userDetails){
        String email = userDetails.getLogin(); 
        String token = generateToken(securityRefresh, new HashMap<String, Object>(), userDetails.getLastName(), email,Integer.MAX_VALUE);
        return token;
    }
    


    public String generateToken(String secret, Map<String, Object> extraClaims, String username, String email, int delta){
        extraClaims.put("email", email);
        Key signingKey = getSigningKey(secret);
    
        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + delta)) 
                .signWith(signingKey)
                .compact();
    }

    

    private Key getSigningKey(String key) {
        byte[] keyBytes = key.getBytes();
        System.out.println("Bytes as string: " + new String(keyBytes));
        return new SecretKeySpec(keyBytes, SignatureAlgorithm.HS256.getJcaName());
    }
    
    
    public boolean validateToken(String token, String secret) {
        System.out.println("Secret:  "+secret);
        try {
            Jwts.parser()
                .setSigningKey(getSigningKey(secret)) 
                .build()
                .parseClaimsJws(token); 
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            System.err.println("Invalid JWT token: " + e.getMessage());
            return false;
        }
    }

    public String getEmail(String token, String secret){
        return extractAllClaims(token, secret).get("email").toString();
    }

    public Claims extractAllClaims(String token, String secret) {
        Key signingKey = getSigningKey(secret);
        return Jwts.parser()
                .setSigningKey(signingKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }


    public boolean isTokenExpired(String token, String secret) {
        Date expiration = extractAllClaims(token, secret).getExpiration();
        return expiration.before(new Date());
    }

    public String refreshAccessToken(String refreshToken) {
        System.out.println("Refresh ACCESS TOKEN");
        if (validateToken(refreshToken, securityRefresh)) {
            String email = getEmail(refreshToken, securityRefresh);
            BankUsersEntity user = userRepository.findByLogin(email);  
            System.out.println(user.getLogin());
            System.out.println("Refreshed");

            return generateAccessToken(user);
        } else {
            throw new JwtException("Invalid or expired refresh token");
        }
    }

    public String getSecurityAccess() {
        return securityAccess;
    }

}
