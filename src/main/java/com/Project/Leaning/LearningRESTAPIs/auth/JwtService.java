package com.Project.Leaning.LearningRESTAPIs.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {

    private final String SECRET_KEY = "secretKey";

    public String generateToken(String email) {

        return Jwts.builder().setSubject(email).setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)).compact();
    }

    public String extractEmail(String token) {

        Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();

        return claims.getSubject();
    }

    public boolean isTokenValid(String token, String email) {
            String extractedEmail = extractEmail(token);

            return email.equals(extractedEmail) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {

        Date expiration = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getExpiration();

        return expiration.before(new Date());
    }
}
