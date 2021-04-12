package br.eti.emersondantas.coursesocialnetwork.api.discipline.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DisciplineNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -1907824913317836090L;

    public DisciplineNotFoundException(){
        super("Disciplina não encontarda.");
    }

}
