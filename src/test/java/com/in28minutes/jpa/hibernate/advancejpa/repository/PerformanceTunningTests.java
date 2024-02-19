package com.in28minutes.jpa.hibernate.advancejpa.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.in28minutes.jpa.hibernate.advancejpa.entity.Course;

import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Subgraph;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class PerformanceTunningTests {

  private Logger log = LoggerFactory.getLogger(this.getClass());

  @Autowired
  EntityManager em;

  @Test
  @Transactional
  public void creatingNPlusOneProblem() {
    List<Course> courses = em.createNamedQuery("query_get_all_courses", Course.class).getResultList();
    for(Course course: courses){
      log.info("Course -> {}", course, course.getStudents());
    }
  }

  @Test
  @Transactional
  public void solvingNPlusOneProblem_EntityGraph() {
    EntityGraph<Course> entityGraph = em.createEntityGraph(Course.class);
    Subgraph<Object> subgraph = entityGraph.addSubgraph("students");
    List<Course> courses = em.createNamedQuery("query_get_all_courses", Course.class)
    .setHint("Javax.persistence.loadgraph", entityGraph)
    .getResultList();
    for(Course course: courses){
      log.info("Course -> {}", course, course.getStudents());
    }
  }

  @Test
  @Transactional
  public void solvingNPlusOneProblem_joinFetch() {
    List<Course> courses = em.createNamedQuery("query_get_all_courses", Course.class).getResultList();
    for(Course course: courses){
      log.info("Course -> {}", course, course.getStudents());
    }
  }
}
