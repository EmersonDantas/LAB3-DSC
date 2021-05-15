package br.eti.emersondantas.coursesocialnetwork.api.auth.dto;

public class LoginResponse {

    public String token;

    public LoginResponse(String token) {
        this.token = token;
    }

}
