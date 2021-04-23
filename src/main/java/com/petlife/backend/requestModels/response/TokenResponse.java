package com.petlife.backend.requestModels.response;

public class TokenResponse {

    private String type = "Bearer";
    private String token;

    public TokenResponse(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
