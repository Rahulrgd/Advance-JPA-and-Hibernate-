package com.in28minutes.jpa.hibernate.advancejpa.repository;

import com.in28minutes.jpa.hibernate.advancejpa.entity.Course;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CourseSpringDataRepository
  extends JpaRepository<Course, Long> {
  List<Course> findByName(String name);
  List<Course> findByNameAndId(String name, Long id);
  List<Course> findByNameOrderByIdDesc(String name);
  List<Course> deleteByName(String name);
  List<Course> countByName(String name);

  @Query("Select c from Course c where id>3")
  List<Course> findCoursesHavingIdGreaterthan3();

  @Query(value = "Select * from Course  where id>3", nativeQuery = true)
  List<Course> nativeQuery();

  @Query(name= "query_courses_where_id>2")
  List<Course> namedQuery();
}
