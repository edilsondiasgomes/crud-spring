package com.edilson.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.edilson.dto.CourseDTO;
import com.edilson.dto.LessonDTO;
import com.edilson.enums.Category;
import com.edilson.model.Course;
import com.edilson.model.Lesson;

@Component
public class CourseMapper {

    public CourseDTO toDTO(Course course) {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setId(course.getId());
        courseDTO.setName(course.getName());
        courseDTO.setCategory(course.getCategory().getValue());

        List<LessonDTO> lessonsDTO = course.getLessons().stream()
                .map(lesson -> {
                    LessonDTO lessonDTO = new LessonDTO();
                    lessonDTO.setId(lesson.getId());
                    lessonDTO.setName(lesson.getName());
                    lessonDTO.setYoutubeUrl(lesson.getYoutubeUrl());
                    return lessonDTO;
                })
                .collect(Collectors.toList());

        courseDTO.setLessons(lessonsDTO);

        return courseDTO;
    }

    public Course toEntity(CourseDTO courseDTO) {
        Course course = new Course();
        if (courseDTO.getId() != null) {
            course.setId(courseDTO.getId());
        }
        course.setName(courseDTO.getName());
        course.setCategory(converteCategoryValue(courseDTO.getCategory()));

        List<Lesson> lesson1 = courseDTO.getLessons().stream()
                .map(lessonDTO -> {
                    Lesson lesson = new Lesson();
                    lesson.setId(lessonDTO.getId());
                    lesson.setName(lessonDTO.getName());
                    lesson.setYoutubeUrl(lessonDTO.getYoutubeUrl());
                    lesson.setCourse(course);
                    return lesson;
                }).collect(Collectors.toList());

        course.setLessons(lesson1);

        return course;
    }

    public Category converteCategoryValue(String value) {
        if (value == null) {
            return null;
        }

        return switch (value) {
            case "Front-end" -> Category.FRONTEND;
            case "Back-end" -> Category.BACKEND;
            default -> throw new IllegalArgumentException("Categoria inválida " + value);

        };
    }

}
