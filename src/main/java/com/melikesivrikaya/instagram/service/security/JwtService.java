package com.melikesivrikaya.instagram.service.security;

import com.melikesivrikaya.instagram.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;


import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtService {
    private final static String SECRET = "aafeeba6959ebeeb96519d5dcf0bcc069f81e4bb56c246d04872db92666e6d4b";
    public String generateToken(UserDetails userDetails) {
        Map<String,Object> claims = new HashMap<>();
        return generateToken(claims, userDetails.getUsername());
    }
    public String generateToken(Map<String,Object> claims , String username){
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 100 * 24 * 60  ))
                .signWith(SignatureAlgorithm.HS256,getSignInKey())
                .compact();
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }


}
