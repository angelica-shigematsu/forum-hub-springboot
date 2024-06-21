package br.com.hub.forum.adapter.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

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
