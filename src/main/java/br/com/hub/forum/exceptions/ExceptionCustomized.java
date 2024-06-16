package br.com.hub.forum.exceptions;

import br.com.hub.forum.dtos.ListUserDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionCustomized {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity manageErro404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity manageErro400(MethodArgumentNotValidException ex) {
        var errors = ex.getFieldErrors();

        return ResponseEntity.badRequest().body(
                errors.stream().map(ErroValidationDTO::new).toList());
                //errors.stream().map(value -> new ErroValidationDTO(value.getField(), value.getDefaultMessage())));

    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity manageDupolicateEntry(DataIntegrityViolationException ex) {
        var message = "Tente outro email";

        var erro = new DuplicateEntry("email", message);
        return ResponseEntity.badRequest().body(erro);
    }

    public record DuplicateEntry(String field, String message) {

    }

    private record ErroValidationDTO(String field, String message) {
        public ErroValidationDTO(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
