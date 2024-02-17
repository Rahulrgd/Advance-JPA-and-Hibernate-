package com.in28minutes.jpa.hibernate.advancejpa;

import com.in28minutes.jpa.hibernate.advancejpa.entity.Course;
import com.in28minutes.jpa.hibernate.advancejpa.entity.FullTimeEmployee;
import com.in28minutes.jpa.hibernate.advancejpa.entity.PartTimeEmployee;
import com.in28minutes.jpa.hibernate.advancejpa.entity.Review;
import com.in28minutes.jpa.hibernate.advancejpa.entity.Student;
import com.in28minutes.jpa.hibernate.advancejpa.repository.CourseRepository;
import com.in28minutes.jpa.hibernate.advancejpa.repository.EmployeeRepository;
import com.in28minutes.jpa.hibernate.advancejpa.repository.StudentRepository;
import java.math.BigDecimal;
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

  @Autowired
  private EmployeeRepository employeeRepository;

  public static void main(String[] args) {
    SpringApplication.run(AdvanceJpaApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    // repository.playWithEntityManager();
    // studentRepository.saveStudentWithPassport();
    // repository.addHardCoddedReviewForCourse();

    // List<Review> reivews = new ArrayList<>();
    // reivews.add(new Review("3", "This Course is Awesome"));
    // reivews.add(new Review("4", "Great Course with Hands on Experience"));
    // repository.addReviewForCourse(10003L, reivews);

    // studentRepository.insertHardCoddedStudentAndCourse();
    // studentRepository.insertStudentAndCourse(
    //   new Student("Shubham"),
    //   new Course("Learn Database Design in 100 steps")
    // );

    employeeRepository.insertEmployee(
      new PartTimeEmployee("Shams", new BigDecimal("50"))
    );
    employeeRepository.insertEmployee(
      new FullTimeEmployee("Shaurabh", new BigDecimal("10000"))
    );
    log.info("All Full Time Employees -> {}", employeeRepository.retrieveAllFullTimeEmployee());
    log.info("All Part Time Employees -> {}", employeeRepository.retrieveAllPartTimeEmployee());
  }
}
