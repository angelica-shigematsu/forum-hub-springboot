package br.com.hub.forum.dtos;

import br.com.hub.forum.models.StatusTopic;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopicDTO(
        @NotBlank
        String title,
        @NotBlank
        String message,
        @NotNull
        StatusTopic statusTopic,

        @NotNull
        long idAuthor,

        @NotNull
        long idCourse) {
}
