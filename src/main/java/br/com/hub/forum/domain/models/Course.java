package br.com.hub.forum.domain.models;

import br.com.hub.forum.adapter.dtos.course.CourseDTO;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="course")
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id;

    @Column(unique = true)
    private String name;

    @Enumerated(EnumType.STRING)
    private Category category;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<TopicModel> topic;
    public Course(CourseDTO courseDto) {
        System.out.println(courseDto.category());
        this.name = courseDto.name();
        this.category = Category.valueOf(courseDto.category().name());
    }
}
