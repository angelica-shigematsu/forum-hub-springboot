package br.com.hub.forum.adapter.dtos.topic;

import br.com.hub.forum.domain.models.StatusTopic;

import java.time.LocalDate;

public record ListTopicAndAuthorAndCourse(
                                          String title,

                                          String message,

                                          StatusTopic statusTopic,

                                          LocalDate dateCreated,

                                          String fullname,

                                          String name) {
}
