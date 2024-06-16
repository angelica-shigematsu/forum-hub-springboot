package br.com.hub.forum.controller;

import br.com.hub.forum.dtos.CourseDTO;
import br.com.hub.forum.models.Course;
import br.com.hub.forum.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    CourseService service;

    @PostMapping("/register")
    public ResponseEntity create(@Valid @RequestBody CourseDTO course) {

        Course courseCreated = service.addCourse(new Course(course));

        return ResponseEntity.ok(courseCreated);
    }
}
