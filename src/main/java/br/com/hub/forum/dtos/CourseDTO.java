package br.com.hub.forum.dtos;

import br.com.hub.forum.models.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CourseDTO(
        @NotBlank
        String name,
        @NotNull
        Category category) {
}
