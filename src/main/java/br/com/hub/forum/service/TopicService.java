package br.com.hub.forum.service;

import br.com.hub.forum.dtos.ListTopicAndAuthorAndCourse;
import br.com.hub.forum.dtos.ListTopicDTO;
import br.com.hub.forum.models.Course;
import br.com.hub.forum.models.TopicModel;
import br.com.hub.forum.models.User;
import br.com.hub.forum.repository.CourseRepository;
import br.com.hub.forum.repository.TopicModelRepository;
import br.com.hub.forum.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicModelRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Transactional
    public ListTopicDTO addTopic(TopicModel topic) {
        TopicModel model = repository.save(topic);

        return new ListTopicDTO(model.getId(),
                model.getTitle(),
                model.getMessage(),
                model.getDateCreated(),
                model.getStatusTopic(),
                model.getIdAuthor(),
                model.getIdCourse());
    }

    public Optional<ListTopicAndAuthorAndCourse> listTopicAndAuhtorAndCourse(long id) {
        Optional<TopicModel> topic = repository.findById(id);


        Optional<User> user = userRepository.findById(topic.get().getIdAuthor());


        Optional<Course> course = courseRepository.findById(topic.get().getIdCourse());

        return Optional.of(new ListTopicAndAuthorAndCourse(topic.get().getTitle(),
                topic.get().getMessage(),
                topic.get().getStatusTopic(),
                user.get().getFullname(),
                course.get().getName()));
    }

    public Optional<TopicModel> findById(long id) {
        Optional<TopicModel> model = repository.findById(id);

        return model;
    }
}
