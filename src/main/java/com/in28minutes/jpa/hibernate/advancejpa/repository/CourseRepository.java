package com.in28minutes.jpa.hibernate.advancejpa.repository;

import com.in28minutes.jpa.hibernate.advancejpa.entity.Course;
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
    em.flush();

    Course course2 = new Course("Learn WebServices");
    em.persist(course2);
    em.flush();

    em.detach(course2);
    em.clear();

    course.setName("Learn SQL Queries - Update");

    course2.setName("Learn WebServices - Update");
    em.flush();
  }
}
