package br.com.hub.forum.adapter.controller;

import br.com.hub.forum.adapter.dtos.response.ListResponseDTO;
import br.com.hub.forum.adapter.dtos.response.ResponseDTO;
import br.com.hub.forum.adapter.dtos.response.ResponseInputDTO;
import br.com.hub.forum.application.service.ResponseService;
import br.com.hub.forum.application.service.TopicService;
import br.com.hub.forum.application.service.UserService;
import br.com.hub.forum.domain.models.Response;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/response")
public class ResponseController {

    @Autowired
    private ResponseService service;

    @Autowired
    private TopicService topicService;

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity createResponse(@Valid @RequestBody ResponseInputDTO responseInputDTO) {
        var topic = topicService.findById(responseInputDTO.idTopic()).get();

        var user = userService.findById(responseInputDTO.idAuthor()).get();

        ResponseDTO dto = new ResponseDTO(responseInputDTO.solution(), user, topic);

        ListResponseDTO listDto = service.addResponse(new Response(dto));

        return ResponseEntity.ok(listDto);
    }
}
