package com.in28minutes.jpa.hibernate.advancejpa.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.in28minutes.jpa.hibernate.advancejpa.entity.Course;
import com.in28minutes.jpa.hibernate.advancejpa.repository.CourseRepository;

@SpringBootTest
class CourseRepositoryTests{

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseRepository repository;

	@Test
	public void findById_basic() {
		Course course = repository.findById(10003L);
		assertEquals("DevOps", course.getName());
	}

	@Test
	@DirtiesContext
	public void deleteById_basic() {
		repository.deleteById(10002L);
		assertNull(repository.findById(10002L));
	}

	@Test
	@DirtiesContext
	public void save_basic() {
		// get a customer
		Course course = repository.findById(10003L);
		assertEquals("DevOps", course.getName());
		// update details
		course.setName("DevOps-Updated");
		// check value
		repository.save(course);
		Course course1 = repository.findById(10003L);
		assertEquals("DevOps-Updated", course1.getName());
	}

	@Test
	@DirtiesContext
	public void playWithEntityManager(){
		repository.playWithEntityManager();
	}

}
