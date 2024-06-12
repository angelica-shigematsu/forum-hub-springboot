package br.com.hub.forum.models;

import br.com.hub.forum.dtos.TopicDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name="topic")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id;

    private String title;

    private String message;

    private LocalDate dateCreated;

    @Enumerated(EnumType.STRING)
    private StatusTopic statusTopic;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User author;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="course_id")
    private Course course;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="response_id")
    private Response response;

    public Topic(TopicDTO topicDto) {
        this.title = topicDto.title();
        this.message = topicDto.message();
        this.dateCreated = topicDto.dateCreated();
        this.statusTopic = StatusTopic.fromString(topicDto.statusTopic().name());
        this.author = new User(topicDto.author());
        this.course = new Course(topicDto.course());
    }
}
