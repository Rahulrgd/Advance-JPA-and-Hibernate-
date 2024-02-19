package com.in28minutes.jpa.hibernate.advancejpa.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.in28minutes.jpa.hibernate.advancejpa.entity.Course;
import com.in28minutes.jpa.hibernate.advancejpa.entity.Review;
import com.in28minutes.jpa.hibernate.advancejpa.repository.CourseRepository;
import jakarta.persistence.EntityManager;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class CourseRepositoryTests {

  private Logger log = LoggerFactory.getLogger(this.getClass());

  @Autowired
  CourseRepository repository;

  @Autowired
  EntityManager em;

  @Test
  public void findById_basic() {
    Course course = repository.findById(10003L);
    log.info("Course -> {}", course);
  }

  @Test
  @Transactional
  public void findById_firstLevelCacheDemo() {
    Course course = repository.findById(10003L);
	log.info("First Course Retrived -> {}", course);
    Course course1 = repository.findById(10003L);
	log.info("First Course Retrived again -> {}", course1);
  }

  @Test
  @DirtiesContext
  public void deleteById_basic() {
    repository.deleteById(10002L);
    assertNull(repository.findById(10002L));
    log.info("Deleted Courses -> ", repository.findById(10002L));
  }

  @Test
  @DirtiesContext
  public void save_basic() {
    // get a customer
    Course course = repository.findById(10003L);
    assertEquals("SQL in 50 steps", course.getName());
    // update details
    course.setName("DevOps-Updated");
    // check value
    repository.save(course);
    Course course1 = repository.findById(10003L);
    assertEquals("DevOps-Updated", course1.getName());
  }

  @Test
  @DirtiesContext
  public void playWithEntityManager() {
    repository.playWithEntityManager();
  }

  @Test
  @Transactional
  public void retriveReviewsForCourses() {
    Course course = repository.findById(10003L);
    log.info("Course Reviews-> {}", course.getReview());
  }

  @Test
  // @Transactional
  public void retriveCourseForReviews() {
    Review review = em.find(Review.class, 50001L);
    log.info("Review Course-> {}", review.getCourse());
  }
}
