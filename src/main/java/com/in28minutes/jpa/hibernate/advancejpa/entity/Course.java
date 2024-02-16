package com.in28minutes.jpa.hibernate.advancejpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
// @Table(name = "CourseDetails")
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

  @Override
  public String toString() {
    return "Course [name=" + name + "]";
  }
}
