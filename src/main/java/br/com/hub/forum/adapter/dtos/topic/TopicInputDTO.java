package br.com.hub.forum.adapter.dtos.topic;

import br.com.hub.forum.domain.models.StatusTopic;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopicInputDTO(@NotBlank
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
