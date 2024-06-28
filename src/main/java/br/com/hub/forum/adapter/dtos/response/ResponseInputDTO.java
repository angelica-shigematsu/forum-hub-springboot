package br.com.hub.forum.adapter.dtos.response;

import jakarta.validation.constraints.NotNull;

public record ResponseInputDTO(
        @NotNull
        String solution,

        @NotNull
        long idAuthor,

        @NotNull
        long idTopic
) {
}
