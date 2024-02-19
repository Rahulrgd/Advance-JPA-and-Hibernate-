package com.in28minutes.jpa.hibernate.advancejpa.repository;

import com.in28minutes.jpa.hibernate.advancejpa.entity.Course;
import com.in28minutes.jpa.hibernate.advancejpa.entity.Review;
import com.in28minutes.jpa.hibernate.advancejpa.entity.ReviewRating;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import java.util.List;
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

  public void addHardCoddedReviewForCourse() {
    // get the course 10003
    Course course = findById(10003L);
    log.info("course.getReview() -> {}", course.getReview());

    // add 2 review to it
    Review review1 = new Review(ReviewRating.FIVE, "This Course is Awesome");
    Review review2 = new Review(ReviewRating.FIVE, "Great Course with Hands on Experience");
    review1.setCourse(course);
    course.addReview(review1);
    course.addReview(review2);
    review2.setCourse(course);

    // save it to the database
    em.persist(review1);
    em.persist(review2);
  }

  public void addReviewForCourse(Long courseId, List<Review> reviews) {
    // get the course 10003
    Course course = findById(courseId);
    log.info("course.getReview() -> {}", course.getReview());

    // add 2 review to it
    for (Review review : reviews) {
      review.setCourse(course);
      course.addReview(review);
      em.persist(review);
    }
  }
}
