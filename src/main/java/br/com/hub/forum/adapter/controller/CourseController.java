package br.com.hub.forum.adapter.controller;

import br.com.hub.forum.adapter.dtos.course.CourseDTO;
import br.com.hub.forum.application.service.CourseService;
import br.com.hub.forum.domain.models.Course;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
@SecurityRequirement(name = "bearer-key")
public class CourseController {
    @Autowired
    private CourseService service;

    @PostMapping("/register")
    public ResponseEntity create(@Valid @RequestBody CourseDTO course) {

        Course courseCreated = service.addCourse(new Course(course));

        return ResponseEntity.ok(courseCreated);
    }
}
