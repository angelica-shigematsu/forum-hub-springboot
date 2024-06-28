package br.com.hub.forum.application.service;

import br.com.hub.forum.adapter.dtos.response.ListResponseDTO;
import br.com.hub.forum.domain.models.Response;
import br.com.hub.forum.infra.repository.ResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResponseService {

    @Autowired
    TopicService topicService;

    @Autowired
    UserService userService;

    @Autowired
    private ResponseRepository repository;

    public ListResponseDTO addResponse(Response response) {
        var responseData = repository.save(response);

        return new ListResponseDTO(
                responseData.getSolution(),
                responseData.getDateCreated(),
                responseData.getAuthor().getFullname(),
                responseData.getTopic().getTitle());
    }
}
