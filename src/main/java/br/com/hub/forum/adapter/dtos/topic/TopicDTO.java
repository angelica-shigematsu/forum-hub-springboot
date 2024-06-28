package br.com.hub.forum.adapter.dtos.topic;

import br.com.hub.forum.domain.models.Course;
import br.com.hub.forum.domain.models.StatusTopic;
import br.com.hub.forum.domain.models.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopicDTO(
        @NotBlank
        String title,
        @NotBlank
        String message,
        @NotNull
        StatusTopic statusTopic,

        @NotBlank
        User author,

        @NotNull
        Course course) {
}
