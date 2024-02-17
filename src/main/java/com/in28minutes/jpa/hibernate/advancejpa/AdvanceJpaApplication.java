package com.in28minutes.jpa.hibernate.advancejpa;

import com.in28minutes.jpa.hibernate.advancejpa.entity.Course;
import com.in28minutes.jpa.hibernate.advancejpa.entity.Review;
import com.in28minutes.jpa.hibernate.advancejpa.repository.CourseRepository;
import com.in28minutes.jpa.hibernate.advancejpa.repository.StudentRepository;
import java.util.ArrayList;
import java.util.List;
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
    // studentRepository.saveStudentWithPassport();
    // repository.addHardCoddedReviewForCourse();
    List<Review> reivews = new ArrayList<>();
    reivews.add(new Review("3", "This Course is Awesome"));
    reivews.add(new Review("4", "Great Course with Hands on Experience"));
    repository.addReviewForCourse(10003L, reivews);
  }
}
