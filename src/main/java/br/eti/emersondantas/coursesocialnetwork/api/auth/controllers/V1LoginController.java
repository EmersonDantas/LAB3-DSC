package br.eti.emersondantas.coursesocialnetwork.api.auth.controllers;

import br.eti.emersondantas.coursesocialnetwork.api.auth.dto.LoginResponse;
import br.eti.emersondantas.coursesocialnetwork.api.jwt.service.JWTService;
import br.eti.emersondantas.coursesocialnetwork.api.user.User;
import br.eti.emersondantas.coursesocialnetwork.api.user.dto.UserCreationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/auth")
public class V1LoginController {

    private final JWTService jwtService;

    @ResponseStatus(code = HttpStatus.OK)
    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public LoginResponse auth(@RequestBody UserCreationDTO user){
        return this.jwtService.autentica(User.from(user));
    }

}
