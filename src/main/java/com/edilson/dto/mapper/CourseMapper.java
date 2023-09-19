package com.edilson.dto.mapper;

import org.springframework.stereotype.Component;

import com.edilson.dto.CourseDTO;
import com.edilson.model.Course;

@Component
public class CourseMapper {

    public CourseDTO toDTO(Course course) {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setId(course.getId());
        courseDTO.setName(course.getName());
        courseDTO.setCategory(course.getCategory());

        return courseDTO;
    }

    public Course toEntity(CourseDTO courseDTO) {
        Course course = new Course();
        if (courseDTO.getId() != null) {
            course.setId(courseDTO.getId());
        }
        course.setName(courseDTO.getName());
        course.setCategory(courseDTO.getCategory());

        return course;
    }

}
