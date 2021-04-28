package com.petlife.backend.services;

import com.petlife.backend.security.UserDetailsImpl;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtServices {
    private static final Logger logger = LoggerFactory.getLogger(JwtServices.class);

    @Value("${petLife.app.jwtSecret}")
    private String jwtSc;

    @Value("${petLife.app.jwtExpirationMs}")
    private int jwtExpirationMiliseconds;

    public String generateJwtToken(Authentication authentication){
        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

        return Jwts.builder()
                .setSubject((userPrincipal.getUsername()))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMiliseconds))
                .signWith(SignatureAlgorithm.HS512, jwtSc)
                .compact();
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSc).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean checkIfExpired(String token){
        try {
            Date expiration = Jwts.parser().setSigningKey(jwtSc).parseClaimsJws(token).getBody().getExpiration();
            return false;
        }
        catch (ExpiredJwtException e){
            logger.error(e.getMessage());
            return true;
        }
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSc).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            logger.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }

        return false;
    }

}
