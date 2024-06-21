package br.com.hub.forum.adapter.controller;

import br.com.hub.forum.adapter.dtos.ListTopicDTO;
import br.com.hub.forum.adapter.dtos.TopicDTO;
import br.com.hub.forum.application.service.CourseService;
import br.com.hub.forum.application.service.TopicService;
import br.com.hub.forum.application.service.UserService;
import br.com.hub.forum.domain.models.Course;
import br.com.hub.forum.domain.models.StatusTopic;
import br.com.hub.forum.domain.models.TopicModel;
import br.com.hub.forum.domain.models.User;
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
public class TopicController {
    @Autowired
    TopicService service;

    @Autowired
    UserService userService;

    @Autowired
    CourseService courseService;

    @PostMapping("/register")
    public ResponseEntity createTopic(@Valid @RequestBody TopicDTO topicDto) {
        Optional<User> user = userService.findById(topicDto.idAuthor());
        Optional<Course> course = courseService.findById(topicDto.idCourse());

        TopicDTO dto = new TopicDTO(topicDto.title(), topicDto.message(),
                topicDto.statusTopic(), topicDto.idAuthor(), topicDto.idCourse());
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

}
