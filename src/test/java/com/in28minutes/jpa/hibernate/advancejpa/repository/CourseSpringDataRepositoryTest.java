package com.in28minutes.jpa.hibernate.advancejpa.repository;

import com.in28minutes.jpa.hibernate.advancejpa.entity.Course;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@SpringBootTest
class CourseSpringDataRepositoryTest {

  private Logger log = LoggerFactory.getLogger(this.getClass());

  @Autowired
  CourseSpringDataRepository repository;

  @Test
  public void findById() {
    Optional<Course> courseOptional = repository.findById(10006L);
    log.info("findById -> {}", courseOptional);
  }

  @Test
  public void findById_course_not_present() {
    Optional<Course> courseOptional = repository.findById(10006L);
    log.info("findById -> {}", courseOptional);
  }

  @Test
  public void playingAroundWithSpringDataRepository() {
    Course course = new Course("Full Stack in 100 steps");
    repository.save(course);
    course.setName("Full Stack in 100 steps - Updated");
    repository.save(course);
  }

  @Test
  public void findall_method() {
    log.info("Courses -> {}", repository.findAll());
    log.info("Courses Count-> {}", repository.count());
  }

  @Test
  public void sort() {
    Sort sort = Sort.by(Sort.Direction.DESC, "name");
    log.info("Sorted Courses -> {}", repository.findAll(sort));
  }

  @Test
  public void pagination() {
    PageRequest pageRequest = PageRequest.of(0, 3);

    // Fetch the first page of results
    Page<Course> firstPage = repository.findAll(pageRequest);
    log.info("First Page -> {}", firstPage.getContent());

    // Fetch the second page
    Pageable secondPageable = firstPage.nextPageable();
    Page<Course> secondPage = repository.findAll(secondPageable);
    log.info("Second Page -> {} ", secondPage.getContent());
  }
  
  @Test
  public void findUsingName() {
    log.info("FindByName -> {}", repository.findByName("Dummy6"));
  }
}
