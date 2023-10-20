package com.edilson;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.edilson.enums.Category;
import com.edilson.model.Course;
import com.edilson.model.Lesson;
import com.edilson.repository.CourseRepository;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

	@Bean
	CommandLineRunner initDataBase(CourseRepository courseRepository) {
		return args -> {
			courseRepository.deleteAll();
			Course c = new Course();
			c.setName("Angular com Spring");
			c.setCategory(Category.FRONTEND);

			Lesson l = new Lesson();
			l.setName("Introdução ao Angular");
			l.setYoutubeUrl("TfSVlTcY&in");
			l.setCourse(c);
			c.getLessons().add(l);

			Lesson l1 = new Lesson();
			l1.setName("Entendendo o Spring");
			l1.setYoutubeUrl("TfSVlTcY&io");
			l1.setCourse(c);
			c.getLessons().add(l1);

			courseRepository.save(c);

		};

	}
}