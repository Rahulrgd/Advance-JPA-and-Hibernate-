package com.in28minutes.jpa.hibernate.advancejpa.repository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.in28minutes.jpa.hibernate.advancejpa.entity.Course;

@SpringBootTest
class CourseSpringDataRepositoryTest{

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseSpringDataRepository repository;

	@Test
	public void findById(){
		Optional<Course> courseOptional = repository.findById(10006L);
		log.info("findById -> {}", courseOptional);
	}

	@Test
	public void findById_course_not_present(){
		Optional<Course> courseOptional = repository.findById(10006L);
		log.info("findById -> {}", courseOptional);
	}

	@Test
	public void playingAroundWithSpringDataRepository(){
		Course course = new Course("Full Stack in 100 steps");
		repository.save(course);
		course.setName("Full Stack in 100 steps - Updated");
		repository.save(course);
	}

	@Test
	public void findall_method(){
		log.info("Courses -> {}", repository.findAll());
		log.info("Courses Count-> {}", repository.count());
	}

}
