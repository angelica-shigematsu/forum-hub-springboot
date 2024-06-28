package br.com.hub.forum.domain.models;

import br.com.hub.forum.adapter.dtos.topic.TopicDTO;
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

    @ManyToOne
    @JoinColumn(name = "id_author")
    private User author;

    @ManyToOne
    @JoinColumn(name = "id_course")
    private Course course;

    public TopicModel(TopicDTO topicDto) {
        this.title = topicDto.title();
        this.message = topicDto.message();
        this.dateCreated = LocalDate.now();
        this.statusTopic = StatusTopic.fromString(topicDto.statusTopic().name());
        this.author = topicDto.author();
        this.course = topicDto.course();
    }

    public void updateTopic(TopicDTO dto) {
        if (dto.title() != null) {
            this.title = dto.title();
        }

        if (dto.message() != null) {
            this.message = dto.message();
        }

        if (dto.statusTopic() != null) {
            this.statusTopic = dto.statusTopic();
        }
    }
}
