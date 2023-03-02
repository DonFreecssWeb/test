package com.example.testerrorendpoint.currency;

import com.example.testerrorendpoint.configuration.JwtProvider;

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class CurrencyServiceImpl {
    @Autowired
    JwtProvider jwtProvider;
    public String generateToken(String fromCurrency,String toCurrency ){
        return jwtProvider.generateToken(fromCurrency,toCurrency);
    }
}
