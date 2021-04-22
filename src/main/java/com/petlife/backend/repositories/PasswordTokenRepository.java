package com.petlife.backend.repositories;

import com.petlife.backend.models.PasswordToken;
import com.petlife.backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PasswordTokenRepository extends JpaRepository<PasswordToken, Long> {
    @Query(value ="FROM recover_token WHERE user_id = ?user", nativeQuery = true)
    List<PasswordToken> findByPersonRequester(User user);

    @Query(value ="FROM recover_token WHERE token = ?token", nativeQuery = true)
    PasswordToken findByToken(String token);
}
