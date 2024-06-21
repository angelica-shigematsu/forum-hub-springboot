package br.com.hub.forum.infra.repository;

import br.com.hub.forum.domain.models.StatusTopic;
import br.com.hub.forum.domain.models.TopicModel;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TopicModelRepository extends JpaRepository<TopicModel, Long>{
    Optional<List<TopicModel>> findByStatusTopic(StatusTopic statusTopic, Pageable page);
}

