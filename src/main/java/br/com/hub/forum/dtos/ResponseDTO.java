package br.com.hub.forum.dtos;

import br.com.hub.forum.models.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.aspectj.weaver.ast.Not;

import java.time.LocalDate;

public record ResponseDTO(
        @NotBlank
        String message,

        @NotNull
        TopicDTO topic,
        @NotNull
        LocalDate dateCreated,

        @NotNull
        UserDTO author,

        @NotNull
        String solution) {
}
