package com.example.safarirides.model;

public class LoginModel {

    String access_token;
    String token_type;
    String id;

    public LoginModel(String access_token, String token_type, String id) {
        this.access_token = access_token;
        this.token_type = token_type;
        this.id = id;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
