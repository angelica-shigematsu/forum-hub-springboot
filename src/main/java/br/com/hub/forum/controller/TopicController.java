package br.com.hub.forum.controller;

import br.com.hub.forum.dtos.ListTopicDTO;
import br.com.hub.forum.dtos.TopicDTO;
import br.com.hub.forum.models.Course;
import br.com.hub.forum.models.TopicModel;
import br.com.hub.forum.models.User;
import br.com.hub.forum.service.CourseService;
import br.com.hub.forum.service.TopicService;
import br.com.hub.forum.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


}
