package com.practice.gateway.authentication;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JWTUtl {

    @Value("${jwt.secret}")
    private String secret;

    public Claims getAllClaims(String token) {
        return Jwts.parser().verifyWith(getPublicSigningKey()).build().parseSignedClaims(token).getPayload();
    }

    private boolean isTokenExpired(String token) {
        return this.getAllClaims(token).getExpiration().before(new Date());
    }
    public boolean isInvalid(String token){
        return this.isTokenExpired(token);
    }

    private SecretKey getPublicSigningKey() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret));
    }
}
