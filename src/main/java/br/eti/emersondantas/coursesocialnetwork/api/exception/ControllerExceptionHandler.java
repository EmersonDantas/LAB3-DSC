package br.eti.emersondantas.coursesocialnetwork.api.exception;

import br.eti.emersondantas.coursesocialnetwork.api.discipline.exceptions.DisciplineNotFoundException;
import br.eti.emersondantas.coursesocialnetwork.api.discipline.exceptions.InvalidTypeException;
import br.eti.emersondantas.coursesocialnetwork.api.jwt.exceptions.InvalidTokenException;
import br.eti.emersondantas.coursesocialnetwork.api.user.exceptions.UserDoesntHavePermissionException;
import br.eti.emersondantas.coursesocialnetwork.api.user.exceptions.UserNotFoundException;
import br.eti.emersondantas.coursesocialnetwork.api.util.StandardError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<StandardError> userNotFoundException(UserNotFoundException e) {
        StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(UserDoesntHavePermissionException.class)
    public ResponseEntity<StandardError> userDoesntHavePermissionException(UserDoesntHavePermissionException e) {
        StandardError err = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }

    @ExceptionHandler(InvalidTokenException.class)
    public ResponseEntity<StandardError> invalidTokenException(InvalidTokenException e) {
        StandardError err = new StandardError(HttpStatus.UNAUTHORIZED.value(), e.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(err);
    }

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
