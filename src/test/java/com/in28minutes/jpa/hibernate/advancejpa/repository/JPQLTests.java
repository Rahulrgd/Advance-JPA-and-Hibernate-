package com.in28minutes.jpa.hibernate.advancejpa.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.in28minutes.jpa.hibernate.advancejpa.entity.Course;
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
}
