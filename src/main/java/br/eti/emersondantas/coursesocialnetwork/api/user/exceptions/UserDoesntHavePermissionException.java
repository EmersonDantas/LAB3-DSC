package br.eti.emersondantas.coursesocialnetwork.api.user.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserDoesntHavePermissionException extends RuntimeException {

    private static final long serialVersionUID = -8043187798854153530L;

    public UserDoesntHavePermissionException(){
        super("Usuario nao tem permissao.");
    }

}
