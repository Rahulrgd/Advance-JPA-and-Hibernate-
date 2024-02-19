package com.in28minutes.jpa.hibernate.advancejpa.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.in28minutes.jpa.hibernate.advancejpa.entity.Address;
import com.in28minutes.jpa.hibernate.advancejpa.entity.Passport;
import com.in28minutes.jpa.hibernate.advancejpa.entity.Student;
import com.in28minutes.jpa.hibernate.advancejpa.repository.StudentRepository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@SpringBootTest
class StudentRepositoryTests{

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StudentRepository repository;

	@Autowired
	EntityManager em;

	@Test
	@Transactional
	public void retrieveStudentsAndPassportDetails() {
		Student student = em.find(Student.class, 20001L);
		log.info("Student -> {}", student);
		log.info("Student Passport -> {}", student.getPassport());
	}

	@Test
	@Transactional
	public void setAddressDetails() {
		Student student = em.find(Student.class, 20001L);
		student.setAddress(new Address("GulzarBagh", "Patna City", "Patna"));
		em.flush();
		log.info("Student -> {}", student);
		log.info("Student Passport -> {}", student.getPassport());
	}

	@Test
	@Transactional
	public void retrievePassportandAssociatedStudentDetails() {
		Passport passport = em.find(Passport.class, 40001L);
		log.info("Passport -> {}", passport);
		log.info("Passport - StudentName -> {}", passport.getStudent());
	}

	@Test
	// @Transactional
	public void someTest() {
		repository.someOperationToUnderstandPersistenceContext();
	}

	@Test
	@Transactional
	public void retrieveStudentAndCourses() {
		Student student = repository.findById(20001L);
		log.info("Student -> {}", student);
		log.info("Student Courses-> {}", student.getCourses());
		
	}

	
}
