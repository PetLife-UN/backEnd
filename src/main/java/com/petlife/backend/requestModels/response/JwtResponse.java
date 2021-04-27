package com.petlife.backend.requestModels.response;

import java.util.List;

public class JwtResponse {

    private String token;
    private String type = "Bearer";
    private Long id;
    private String Username;
    private String email;

    private List<String> roles;

    public JwtResponse( Long id, String Username, String email, List<String> roles, String accessToken) {
        this.id = id;
        this.Username = Username;
        this.email = email;
        this.roles = roles;
        this.token = accessToken;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String name) {
        this.Username = name;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
