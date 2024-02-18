package com.in28minutes.jpa.hibernate.advancejpa.repository;

import com.in28minutes.jpa.hibernate.advancejpa.entity.Course;
import com.in28minutes.jpa.hibernate.advancejpa.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CriteriaQuerryTest {

  private Logger log = LoggerFactory.getLogger(this.getClass());

  @Autowired
  EntityManager em;

  @Test
  public void all_courses() {
    // "Select c From Course c"
    // 1. Use Criteria Builder to create Query returning the expected result object
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Course> cq = cb.createQuery(Course.class);

    // 2. Define roots for tables which are involved in the query
    Root<Course> courseRoot = cq.from(Course.class);

    // 3. Define predicates etc using Criteria Builder
    // 4. Add predicates etc to the Criteria Query
    // 5. Build the Typed Query using the entity manager and Criteria query
    TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
    List<Course> resultList = query.getResultList();
    log.info("Typed Query -> {}", resultList);
  }

  @Test
  public void all_courses_having_100_steps() {
    // "Select c From Course c where name like '%100 steps'"
    // 1. Use Criteria Builder to create Query returning the expected result object
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Course> cq = cb.createQuery(Course.class);

    // 2. Define roots for tables which are involved in the query
    Root<Course> courseRoot = cq.from(Course.class);

    // 3. Define predicates etc using Criteria Builder
    Predicate like100steps = cb.like(courseRoot.get("name"), "%100 steps");

    // 4. Add predicates etc to the Criteria Query
    cq.where(like100steps);

    // 5. Build the Typed Query using the entity manager and Criteria query
    TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
    List<Course> resultList = query.getResultList();
    log.info("Typed Query -> {}", resultList);
  }
}
