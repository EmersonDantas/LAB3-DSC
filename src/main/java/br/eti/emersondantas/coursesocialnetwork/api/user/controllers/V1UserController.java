package br.eti.emersondantas.coursesocialnetwork.api.user.controllers;

import br.eti.emersondantas.coursesocialnetwork.api.user.User;
import br.eti.emersondantas.coursesocialnetwork.api.user.dto.UserCreationDTO;
import br.eti.emersondantas.coursesocialnetwork.api.user.dto.UserDTO;
import br.eti.emersondantas.coursesocialnetwork.api.user.service.CreateUserService;
import br.eti.emersondantas.coursesocialnetwork.api.user.service.DeleteUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1")
public class V1UserController {

    private final CreateUserService createUserService;

    private final DeleteUserService deleteUserService;

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(value = "/usuarios", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO create(@RequestBody UserCreationDTO user){
        return UserDTO.from(this.createUserService.create(User.from(user)));
    }

    @ResponseStatus(code = HttpStatus.OK)
    @DeleteMapping(value = "/auth/usuarios/{email}")
    public void delete(@PathVariable String email,
                       @RequestHeader("Authorization") String header){
        this.deleteUserService.delete(email, header);
    }

}
