package br.com.hub.forum.models;

import br.com.hub.forum.dtos.TopicDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name="topic")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class TopicModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id;

    private String title;

    private String message;

    private LocalDate dateCreated;

    @Enumerated(EnumType.STRING)
    private StatusTopic statusTopic;

    private long idAuthor;

    private long idCourse;

    public TopicModel(TopicDTO topicDto) {
        this.title = topicDto.title();
        this.message = topicDto.message();
        this.dateCreated = LocalDate.now();
        this.statusTopic = StatusTopic.fromString(topicDto.statusTopic().name());
        this.idAuthor = topicDto.idAuthor();
        this.idCourse = topicDto.idCourse();
    }
}
