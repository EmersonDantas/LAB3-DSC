package br.eti.emersondantas.coursesocialnetwork.api.discipline.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidTypeException extends RuntimeException {
    private static final long serialVersionUID = 8327468025138049539L;

    public InvalidTypeException(){
        super("Tipo de dado enviado é inválido.");
    }

}
