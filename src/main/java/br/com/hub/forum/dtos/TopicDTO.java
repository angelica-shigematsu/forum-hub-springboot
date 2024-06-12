package br.com.hub.forum.dtos;

import br.com.hub.forum.models.StatusTopic;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;

public record TopicDTO(
        @NotBlank
        String title,
        @NotBlank
        String message,
        @CreatedDate
        LocalDate dateCreated,

        @NotNull
        StatusTopic statusTopic,

        @NotNull
        @Valid
        UserDTO author,

        @NotNull
        @Valid
        CourseDTO course,

        @NotNull
        @Valid
        ResponseDTO response) {
}
