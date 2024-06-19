package br.com.hub.forum.dtos;

import br.com.hub.forum.models.StatusTopic;

public record ListTopicAndAuthorAndCourse(
                                          String title,

                                          String message,

                                          StatusTopic statusTopic,

                                          String fullname,

                                          String name) {
}
