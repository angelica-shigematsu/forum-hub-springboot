package br.com.hub.forum.exceptions;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

public class FindUserEmailException extends Throwable {
    @Getter
    @JsonProperty("status_code")
    private int status;

    private String message;


    public FindUserEmailException() {
        this.status = 400;
        this.message = "Erro. Tente outro email";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
