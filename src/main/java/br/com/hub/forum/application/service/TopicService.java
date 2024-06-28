package br.com.hub.forum.application.service;

import br.com.hub.forum.adapter.dtos.topic.FindTopicByCourseDTO;
import br.com.hub.forum.adapter.dtos.topic.ListTopicAndAuthorAndCourse;
import br.com.hub.forum.adapter.dtos.topic.ListTopicDTO;
import br.com.hub.forum.adapter.dtos.topic.TopicDTO;
import br.com.hub.forum.domain.models.Course;
import br.com.hub.forum.domain.models.StatusTopic;
import br.com.hub.forum.domain.models.TopicModel;
import br.com.hub.forum.domain.models.User;
import br.com.hub.forum.infra.repository.CourseRepository;
import br.com.hub.forum.infra.repository.TopicModelRepository;
import br.com.hub.forum.infra.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
                model.getAuthor().getId(),
                model.getCourse().getId());
    }

    public Optional<ListTopicAndAuthorAndCourse> listTopicAndAuhtorAndCourse(long id) {
        Optional<TopicModel> topic = repository.findById(id);


        Optional<User> user = userRepository.findById(topic.get().getId());


        Optional<Course> course = courseRepository.findById(topic.get().getId());

        return Optional.of(new ListTopicAndAuthorAndCourse(topic.get().getTitle(),
                topic.get().getMessage(),
                topic.get().getStatusTopic(),
                topic.get().getDateCreated(),
                user.get().getFullname(),
                course.get().getName()));
    }

    public Optional<TopicModel> findById(long id) {
        Optional<TopicModel> model = repository.findById(id);

        return model;
    }

    public Optional<List<TopicModel>> findAllTopicsByDateCreated(StatusTopic statusTopic, Pageable page) {
       return repository.findByStatusTopic(statusTopic, page);
    }

    public Optional<List<FindTopicByCourseDTO>> findAllTopicsWithCourses(String name) {
        return repository.findAllTopicWithCourse(name);
    }

    public void updateTopic(TopicDTO dto, long id) {
        var topic = repository.getReferenceById(id);
        topic.updateTopic(dto);
    }

    public void removeTopic(long id) {
        repository.deleteById(id);
    }
}
