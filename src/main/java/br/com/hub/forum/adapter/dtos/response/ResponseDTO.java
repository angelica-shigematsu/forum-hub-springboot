package br.com.hub.forum.adapter.dtos.response;

import br.com.hub.forum.domain.models.TopicModel;
import br.com.hub.forum.domain.models.User;
import jakarta.validation.constraints.NotNull;

public record ResponseDTO(
        @NotNull
        String solution,

        @NotNull
        User author,

        @NotNull
        TopicModel topic
        ) {
}
