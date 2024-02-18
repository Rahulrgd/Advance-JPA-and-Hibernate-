package com.in28minutes.jpa.hibernate.advancejpa.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.in28minutes.jpa.hibernate.advancejpa.entity.Course;
import com.in28minutes.jpa.hibernate.advancejpa.entity.Student;
import com.in28minutes.jpa.hibernate.advancejpa.repository.CourseRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest
class JPQLTests {

  private Logger log = LoggerFactory.getLogger(this.getClass());

  @Autowired
  EntityManager em;

  @Test
  public void jpql_basic() {
    List resultList = em
      .createNamedQuery("query_get_all_courses")
      .getResultList();
    log.info("Select c from Course c -> {}", resultList);
  }

  @Test
  public void jpql_typed() {
    TypedQuery<Course> query = em.createNamedQuery(
      "query_get_all_courses",
      Course.class
    );
    List<Course> resultList = query.getResultList();
    log.info("Select c from Course c -> {}", resultList);
  }

  @Test
  public void jpql_where() {
    TypedQuery<Course> query = em.createNamedQuery(
      "query_courses_where_id>2",
      Course.class
    );
    List<Course> resultList = query.getResultList();
    log.info("Select c from Course c where id>3 -> {}", resultList);
  }

  @Test
  public void jpql_courses_without_students() {
    TypedQuery<Course> query = em.createQuery(
      "Select c from Course c where c.students is empty",
      Course.class
    );
    List<Course> resultList = query.getResultList();
    log.info("Select c from Course c.student is empty -> {}", resultList);
  }

  @Test
  public void jpql_courses_with_atleast_2_students() {
    TypedQuery<Course> query = em.createQuery(
      "Select c from Course c where size(c.students) >= 2",
      Course.class
    );
    List<Course> resultList = query.getResultList();
    log.info("Select c from Course c where size(c.students) >= 2 -> {}", resultList);
  }

  @Test
  public void jpql_courses_ordered_by_students() {
    TypedQuery<Course> query = em.createQuery(
      "Select c from Course c order by size(c.students)",
      Course.class
    );
    List<Course> resultList = query.getResultList();
    log.info("Ordered by students -> {}", resultList);
  }

  @Test
  public void jpql_courses_ordered_by_decending_students() {
    TypedQuery<Course> query = em.createQuery(
      "Select c from Course c order by size(c.students) desc",
      Course.class
    );
    List<Course> resultList = query.getResultList();
    log.info("Ordered by Descending students -> {}", resultList);
  }

  @Test
  public void jpql_students_with_passport_in_a_certain_pattern() {
    TypedQuery<Student> query = em.createQuery(
      "Select s from Student s where s.passport.number like '%1234%'",
      Student.class
    );
    List<Student> resultList = query.getResultList();
    log.info("Students Passport containing 1234 -> {}", resultList);
  }
}
