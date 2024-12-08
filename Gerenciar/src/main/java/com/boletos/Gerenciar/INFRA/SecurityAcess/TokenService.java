package com.boletos.Gerenciar.INFRA.SecurityAcess;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.boletos.Gerenciar.ENTITY.LoginEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(LoginEntity loginEntity){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .withIssuer("auth-api")
                    .withSubject(loginEntity.getUsername())
                    .withExpiresAt(genExperationDate())
                    .sign(algorithm);
            return token;
        }catch (JWTCreationException j){
            throw new RuntimeException("Error while generation token ", j);
        }
    }

    public String validationToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            return JWT.require(algorithm)
                    .withIssuer("auth-api")
                    .build()
                    .verify(token)
                    .getSubject();

        }catch (JWTVerificationException j){
            return "";
        }
    }

    private Instant genExperationDate(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
