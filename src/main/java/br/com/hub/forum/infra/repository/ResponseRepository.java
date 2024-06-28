package br.com.hub.forum.infra.repository;

import br.com.hub.forum.domain.models.Response;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResponseRepository extends JpaRepository<Response, Long> {
}
