package br.eti.emersondantas.coursesocialnetwork.api.discipline.exceptions;

import br.eti.emersondantas.coursesocialnetwork.api.util.StandardError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class DisciplineControllerV1ExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DisciplineNotFoundException.class)
    public ResponseEntity<StandardError> disciplineNotFoundException(DisciplineNotFoundException e) {
        StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(InvalidTypeException.class)
    public ResponseEntity<StandardError> invalidTypeException(InvalidTypeException e) {
        StandardError err = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<StandardError> runtimeException(RuntimeException e) {
        e.printStackTrace();
        StandardError err = new StandardError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal server error", System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err);
    }
}
