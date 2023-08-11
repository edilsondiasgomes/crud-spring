package com.edilson.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edilson.model.Course;

// @Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
