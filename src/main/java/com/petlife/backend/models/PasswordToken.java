package com.petlife.backend.models;

import javax.persistence.*;

@Entity
@Table(name = "recover_token")
public class PasswordToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "token_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User UserRequester;

    @Column(name = "token")
    private String token;

    @Column(name = "generated_at")
    private long generatedAt;

    public PasswordToken(User userRequester, String token, long generatedAt) {
        UserRequester = userRequester;
        this.token = token;
        this.generatedAt = generatedAt;
    }

    public PasswordToken() {

    }

    public User getUserRequester() {
        return UserRequester;
    }

    public void setUserRequester(User userRequester) {
        UserRequester = userRequester;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getGeneratedAt() {
        return generatedAt;
    }

    public void setGeneratedAt(long generatedAt) {
        this.generatedAt = generatedAt;
    }
}
