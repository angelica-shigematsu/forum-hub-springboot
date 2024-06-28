package br.com.hub.forum.domain.models;

import br.com.hub.forum.adapter.dtos.response.ResponseDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name="response")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of= "id")
public class Response {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id;

    private String solution;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="topic_id")
    private TopicModel topic;

    private LocalDate dateCreated;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private User author;

    public Response(ResponseDTO responseDto) {
        this.solution = responseDto.solution();
        this.dateCreated = LocalDate.now();
        this.author = responseDto.author();
        this.topic = responseDto.topic();
    }
}
