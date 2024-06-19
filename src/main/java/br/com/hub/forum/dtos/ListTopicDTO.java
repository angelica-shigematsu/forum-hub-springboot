package br.com.hub.forum.dtos;

import br.com.hub.forum.models.StatusTopic;

import java.time.LocalDate;

public record ListTopicDTO(
        Long id,

        String title,

        String message,

        LocalDate dateCreated,

        StatusTopic status,

        long idAuthor,

        long idCourse) {
}
