package br.com.hub.forum.adapter.dtos.course;

import br.com.hub.forum.domain.models.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CourseDTO(
        @NotBlank
        String name,
        @NotNull
        Category category) {
}
