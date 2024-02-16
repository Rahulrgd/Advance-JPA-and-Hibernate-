package com.in28minutes.jpa.hibernate.advancejpa.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.in28minutes.jpa.hibernate.advancejpa.entity.Course;
import com.in28minutes.jpa.hibernate.advancejpa.repository.CourseRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest
class NativeQueriesTests {

  private Logger log = LoggerFactory.getLogger(this.getClass());

  @Autowired
  EntityManager em;

  @Test
  public void native_queries_basic() {
    Query query = em.createNativeQuery("Select * from Course", Course.class);
    List resultList = query.getResultList();
    log.info("Select * from Course -> {}", resultList);
  }

  @Test
  public void native_queries_with_parameters() {
    Query query = em.createNativeQuery(
      "Select * from Course where id = ?",
      Course.class
    );
    query.setParameter(1, 10001L);
    List resultList = query.getResultList();
    log.info("Select * from Course where id = ? -> {}", resultList);
  }

  @Test
  public void native_queries_with_named_parameters() {
    Query query = em.createNativeQuery(
      "Select * from Course where id = :id",
      Course.class
    );
    query.setParameter("id", 10001L);
    List resultList = query.getResultList();
    log.info("Select * from Course where id = :id -> {}", resultList);
  }

  @Test
  @Transactional
  public void native_queries_to_update() {
    Query query = em.createNativeQuery("Update Course set last_updated_date=CURRENT_TIMESTAMP()", Course.class);
    int rowsAffected = query.executeUpdate();
    log.info("rowsAffected -> {}", rowsAffected);
  }
}
