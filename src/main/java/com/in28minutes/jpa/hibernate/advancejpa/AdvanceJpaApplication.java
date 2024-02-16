package com.in28minutes.jpa.hibernate.advancejpa;

import com.in28minutes.jpa.hibernate.advancejpa.entity.Course;
import com.in28minutes.jpa.hibernate.advancejpa.repository.CourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdvanceJpaApplication implements CommandLineRunner {

  Logger log = LoggerFactory.getLogger(this.getClass());

  @Autowired
  CourseRepository repository;

  public static void main(String[] args) {
    SpringApplication.run(AdvanceJpaApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    Course course = repository.findById(10001L);
    log.info("Course 10001 -> {}", course);
    repository.deleteById(10001L);
  }
}
