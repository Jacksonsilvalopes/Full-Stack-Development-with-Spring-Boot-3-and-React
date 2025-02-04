package com.pack.cardatabase.service;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Date;



@Component
public class JwtService {
    static final long EXPIRATIONTIME = 86400000; // 1 day in ms. Should be shorter in production.
    static final String PREFIX = "Bearer";

    // Gere a chave secreta. Somente para fins de demonstração.
    // Na produção, você deve lê-lo na configuração do aplicativo.
    static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    // Gerar token JWT assinado
    public String getToken(String username) {
        String token = Jwts.builder().setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME)).signWith(key).compact();

        return token;
    }

    // Obtenha um token do cabeçalho de autorização da solicitação,
    // verifique o token e obtenha o nome de usuário
    public String getAuthUser(HttpServletRequest request) {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (token != null) {
            String user = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token.replace(PREFIX, ""))
                    .getBody().getSubject();

            if (user != null)
                return user;
        }
        return null;
    }
}


