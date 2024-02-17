package com.in28minutes.jpa.hibernate.advancejpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Review {

  @Id
  @GeneratedValue
  private Long id;

  private String rating;

  private String description;

  @ManyToOne
  private Course course;

  public Review() {}

  public Review(String rating, String description) {
    this.rating = rating;
    this.description = description;
  }

  public String getdescription() {
    return description;
  }

  public void setdescription(String description) {
    this.description = description;
  }

  public Long getId() {
    return id;
  }

  public String getRating() {
    return rating;
  }

  public void setRating(String rating) {
    this.rating = rating;
  }

  public Course getCourse() {
    return course;
  }

  public void setCourse(Course course) {
    this.course = course;
  }

  @Override
  public String toString() {
    return "Review [rating=" + rating + ", description=" + description + "]";
  }
}
