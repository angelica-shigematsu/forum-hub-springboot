package br.com.hub.forum.infra.repository;

import br.com.hub.forum.adapter.dtos.topic.FindTopicByCourseDTO;
import br.com.hub.forum.domain.models.StatusTopic;
import br.com.hub.forum.domain.models.TopicModel;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TopicModelRepository extends JpaRepository<TopicModel, Long>{
    Optional<List<TopicModel>> findByStatusTopic(StatusTopic statusTopic, Pageable page);

    @Query("""
            SELECT new br.com.hub.forum.adapter.dtos.topic.FindTopicByCourseDTO(t.title, t.message, c.name, u.fullname)
                FROM TopicModel t JOIN t.author u JOIN t.course c
                WHERE c.name LIKE :name% AND t.statusTopic='PUBLICADO'""")
    Optional<List<FindTopicByCourseDTO>> findAllTopicWithCourse(@Param("name") String name);
}

