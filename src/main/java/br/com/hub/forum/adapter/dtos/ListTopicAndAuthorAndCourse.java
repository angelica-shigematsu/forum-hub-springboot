package br.com.hub.forum.adapter.dtos;

import br.com.hub.forum.domain.models.StatusTopic;

public record ListTopicAndAuthorAndCourse(
                                          String title,

                                          String message,

                                          StatusTopic statusTopic,

                                          String fullname,

                                          String name) {
}
