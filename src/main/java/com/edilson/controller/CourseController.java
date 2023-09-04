package com.edilson.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.edilson.model.Course;
import com.edilson.service.CourseService;

@Validated
@RequestMapping("/api/courses")
@RestController
// @AllArgsConstructor

public class CourseController {

    private final CourseService courseService;

    // @RequestMapping(method=RequestMethod.GET)

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> list() {
        return courseService.List();
    }

    @GetMapping("/{id}")
    public Course findById(@PathVariable @NotNull @Positive Long id) {
        return courseService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Course create(@RequestBody @Valid Course course) {
        return courseService.create(course);
        // return
        // ResponseEntity.status(HttpStatus.CREATED).body(courseRepository.save(course));
    }

    @PutMapping("/{id}")
    public Course update(@PathVariable @NotNull @Positive Long id, @RequestBody @Valid Course course) {
        return courseService.update(id, course);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @NotNull @Positive Long id) {
        courseService.delete(id);

    }

}
