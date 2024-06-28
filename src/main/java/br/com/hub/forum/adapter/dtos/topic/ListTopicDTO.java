package br.com.hub.forum.adapter.dtos.topic;

import br.com.hub.forum.domain.models.StatusTopic;

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
