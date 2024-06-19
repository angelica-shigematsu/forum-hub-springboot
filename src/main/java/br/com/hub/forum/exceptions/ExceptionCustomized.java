package br.com.hub.forum.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class ExceptionCustomized {

    // Utilizar a anotação @ExceptionHandler, do Spring, para indicar qual exception um determinado método da classe de tratamento de erros deve capturar;
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity manageErro404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity manageErrorInput(){
        return ResponseEntity.badRequest().body("message: Falta campos");
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
