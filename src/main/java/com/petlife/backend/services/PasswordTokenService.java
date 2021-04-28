package com.petlife.backend.services;

import com.petlife.backend.models.PasswordToken;
import com.petlife.backend.models.User;
import com.petlife.backend.repositories.PasswordTokenRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PasswordTokenService {
    @Autowired
    PasswordTokenRepository repository;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Value("${petLife.app.jwtSecret}")
    private String jwtSc;

    @Value("${petLife.app.jwtPasswordExpirationMs}")
    private int jwtExpirationMiliseconds;

    public List<PasswordToken> getAll(){
        return repository.findAll();
    }

    public List<PasswordToken> getTokensByUser(User user){
        return repository.findByPersonRequester(user);
    }

    public PasswordToken getTokenbyStringToken(String token){
        return repository.findByToken(token);
    }

    public PasswordToken generatePasswordRecoveryToken (User user){
        String tokenString = Jwts.builder().
                setIssuedAt(new Date())
                .setSubject(user.getUsername())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMiliseconds))
                .signWith(SignatureAlgorithm.HS512, jwtSc).compact();

        PasswordToken passwordToken = new PasswordToken(user, tokenString, new Date().getTime());
        repository.save(passwordToken);
        return passwordToken;
    }

    public String getUsername(String token){
        return Jwts.parser().setSigningKey(jwtSc).parseClaimsJws(token).getBody().getSubject();
    }


    public String encryptPassword(String password) {
        return passwordEncoder.encode(password);
    }

}
