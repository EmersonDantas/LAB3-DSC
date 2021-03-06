package br.eti.emersondantas.coursesocialnetwork.api.user.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -1907824913317836090L;

    public UserNotFoundException(){
        super("Usuário não encontardo.");
    }

}
