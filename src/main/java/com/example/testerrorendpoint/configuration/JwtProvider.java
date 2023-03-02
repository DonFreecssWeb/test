package com.example.testerrorendpoint.configuration;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {
    private final byte [] signinKey;
    private final String  SECRET_KEY ="secretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecret";
    private final long tokenValidityInSeconds;
    private final long getTokenValidityInSecondsForAmount;

    public JwtProvider(){
        this.signinKey = Decoders.BASE64.decode(SECRET_KEY);
        this.tokenValidityInSeconds = 180;
        this.getTokenValidityInSecondsForAmount = 240;
    }

    public String generateToken(String fromCurrency, String toCurrency){

        return Jwts.builder().claim("from",fromCurrency).claim("to",toCurrency)
                .setExpiration(new Date(System.currentTimeMillis() + tokenValidityInSeconds * 1000))
                .setIssuedAt(new Date())
                .signWith(Keys.hmacShaKeyFor(signinKey), SignatureAlgorithm.HS256)
                .compact();
    }
}
