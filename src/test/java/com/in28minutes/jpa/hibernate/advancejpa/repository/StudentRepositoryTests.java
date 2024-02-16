package com.in28minutes.jpa.hibernate.advancejpa.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.in28minutes.jpa.hibernate.advancejpa.entity.Student;
import com.in28minutes.jpa.hibernate.advancejpa.repository.StudentRepository;

import jakarta.persistence.EntityManager;

@SpringBootTest
class StudentRepositoryTests{

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StudentRepository repository;

	@Autowired
	EntityManager em;

	@Test
	public void retrieveStudentsAndPassportDetails() {
		Student student = em.find(Student.class, 20001L);
		log.info("Student -> {}", student);
		log.info("Student Passport -> {}", student.getPassport());
	}
}
