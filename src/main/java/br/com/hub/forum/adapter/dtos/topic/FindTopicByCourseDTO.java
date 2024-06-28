package br.com.hub.forum.adapter.dtos.topic;

public record FindTopicByCourseDTO(
        String title,
        String message,
        String fullname,
        String name) {
}
