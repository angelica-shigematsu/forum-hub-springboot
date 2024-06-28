package br.com.hub.forum.adapter.dtos.response;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ListResponseDTO(
        String solution,

        LocalDate dateCreated,

        @NotNull
        String fullname,

        String title
) {
}
