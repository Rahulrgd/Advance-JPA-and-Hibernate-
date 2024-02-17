package com.in28minutes.jpa.hibernate.advancejpa.repository;

import com.in28minutes.jpa.hibernate.advancejpa.entity.Course;
import com.in28minutes.jpa.hibernate.advancejpa.entity.Review;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseRepository {

  Logger log = LoggerFactory.getLogger(this.getClass());

  @Autowired
  EntityManager em;

  public Course findById(long id) {
    return em.find(Course.class, id);
  }

  public Course save(Course course) {
    if (course.getId() == null) {
      em.persist(course);
    } else {
      em.merge(course);
    }

    return course;
  }

  public void deleteById(long id) {
    Course course = em.find(Course.class, id);
    em.remove(course);
  }

  public void playWithEntityManager() {
    Course course = new Course("Learn SQL Queries");
    em.persist(course);

    Course course2 = findById(10001L);
    course2.setName("AWS in 100 steps - Updated");
  }

  public void addReviewForCourse(){
    // get the course 10003
    Course course = findById(10003L);
    log.info("course.getReview() -> {}", course.getReview());
    
    // add 2 review to it
    // course.addReview(new Review(3, "This Course is Awesome"));
    // save it to the database
  }
}
