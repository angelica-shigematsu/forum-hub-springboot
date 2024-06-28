package br.com.hub.forum.adapter.controller;

import br.com.hub.forum.adapter.dtos.topic.*;
import br.com.hub.forum.application.service.CourseService;
import br.com.hub.forum.application.service.TopicService;
import br.com.hub.forum.application.service.UserService;
import br.com.hub.forum.domain.models.Course;
import br.com.hub.forum.domain.models.StatusTopic;
import br.com.hub.forum.domain.models.TopicModel;
import br.com.hub.forum.domain.models.User;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topic")
@SecurityRequirement(name = "bearer-key")
public class TopicController {
    @Autowired
    TopicService service;

    @Autowired
    UserService userService;

    @Autowired
    CourseService courseService;

    @PostMapping("/register")
    public ResponseEntity createTopic(@Valid @RequestBody TopicInputDTO topicDto) {
        User user = userService.findById(topicDto.idAuthor()).get();
        Course course = courseService.findById(topicDto.idCourse()).get();

        TopicDTO dto = new TopicDTO(topicDto.title(), topicDto.message(),
                topicDto.statusTopic(), user, course);
        ListTopicDTO topic = service.addTopic(new TopicModel(dto));

        return ResponseEntity.ok(topic);
    }

    @GetMapping("/getData/{id}")
    public ResponseEntity listTopicById(@PathVariable long id) {
        return ResponseEntity.ok(service.listTopicAndAuhtorAndCourse(id));
    }


    @GetMapping("/getAllData")
    public Optional<List<TopicModel>> listAllByDate(@PageableDefault(size=10, sort={"dateCreated"})
                                                    @RequestParam(required = false) StatusTopic status, Pageable page
   ) {
        return service.findAllTopicsByDateCreated(status=StatusTopic.PUBLICADO, page);
    }

    @GetMapping
    public ResponseEntity findTopicByCourse(@RequestBody GetNameCourseDTO dto) {
        Optional<List<FindTopicByCourseDTO>> topic = service.findAllTopicsWithCourses(dto.name());
        return ResponseEntity.ok(topic);
    }

    @PutMapping
    public ResponseEntity updateTopic(@RequestBody @Valid TopicDTO dto, @PathVariable long id) {
        service.updateTopic(dto, id);
        return ResponseEntity.status(200).body("Dados os tópicos foram alterados");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTopic(@PathVariable long id) {
        service.removeTopic(id);
        return ResponseEntity.ok("Removido com sucesso");
    }
}
