package com.in28minutes.jpa.hibernate.advancejpa;

import com.in28minutes.jpa.hibernate.advancejpa.entity.Course;
import com.in28minutes.jpa.hibernate.advancejpa.repository.CourseRepository;
import com.in28minutes.jpa.hibernate.advancejpa.repository.StudentRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdvanceJpaApplication implements CommandLineRunner {

  private Logger log = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private CourseRepository repository;

  @Autowired
  private StudentRepository studentRepository;

  public static void main(String[] args) {
    SpringApplication.run(AdvanceJpaApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    // repository.playWithEntityManager();
    studentRepository.saveStudentWithPassport();
    repository.addReviewForCourse();
  }
}
