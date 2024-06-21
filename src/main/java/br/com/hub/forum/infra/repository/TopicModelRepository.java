package br.com.hub.forum.infra.repository;

import br.com.hub.forum.domain.models.TopicModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicModelRepository extends JpaRepository<TopicModel, Long>{
}

