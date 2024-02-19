package com.in28minutes.jpa.hibernate.advancejpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
// @Table(name = "CourseDetails")
// @EnableCaching
// @Cacheable - Not Sure Cacheable annotation working or not
@NamedQueries(
  value = {
    @NamedQuery(
      name = "query_get_all_courses",
      query = "select c from Course c"
    ),
    @NamedQuery(
      name = "query_courses_where_id>2",
      query = "Select c from Course c where id>3"
    ),
  }
)
public class Course {

  @Id
  @GeneratedValue
  private Long id;

  @Column(name = "fullname", nullable = false)
  private String name;

  // @OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
  @OneToMany(mappedBy = "course")
  private List<Review> review = new ArrayList<>();

  @ManyToMany(mappedBy = "courses")
  @JsonIgnore
  private List<Student> students = new ArrayList<>();

  @UpdateTimestamp
  private LocalDateTime lastUpdatedDate;

  @CreationTimestamp
  private LocalDateTime createdDate;

  protected Course() {}

  public Course(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public List<Review> getReview() {
    return review;
  }

  public void addReview(Review review) {
    this.review.add(review);
  }

  public void removeReview(Review review) {
    this.review.remove(review);
  }

  public List<Student> getStudents() {
    return students;
  }

  public void addStudents(Student student) {
    this.students.add(student);
  }

  @Override
  public String toString() {
    return "Course [name=" + name + "]";
  }
}
