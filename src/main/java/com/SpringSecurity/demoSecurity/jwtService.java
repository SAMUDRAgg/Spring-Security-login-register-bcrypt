package com.SpringSecurity.demoSecurity;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.http.ResponseEntity;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class jwtService {


    public ResponseEntity<String> generateToken(String username) {
    Map<String,Object> claims=new HashMap<>();

    return Jwts.builder()
            .setClaims(claims)
            .setSubject(username)
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis() + 10000*60*3))
            .signWith(getKey(), SignatureAlgorithm.HS256).compact();
    }

    private KEY getKey(){

        byte[] keyBytes= Decoder.BASE64.decode(secrectKey)
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
