package br.com.hub.forum.service;

import br.com.hub.forum.models.Course;
import br.com.hub.forum.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository repository;

    @Transactional
    public Course addCourse(Course course) {
       return repository.save(course);
    }
}
