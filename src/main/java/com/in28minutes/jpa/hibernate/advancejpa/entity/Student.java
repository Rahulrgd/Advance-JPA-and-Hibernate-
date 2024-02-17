package com.in28minutes.jpa.hibernate.advancejpa.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Student {

  @Id
  @GeneratedValue
  private Long id;

  @Column(nullable = false)
  private String name;

  @OneToOne(fetch = FetchType.LAZY)
  private Passport passport;

  @ManyToMany
  private List<Course> courses = new ArrayList<>();

  protected Student() {}

  public Student(String name) {
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

  public Passport getPassport() {
    return passport;
  }

  public void setPassport(Passport passport) {
    this.passport = passport;
  }

  public List<Course> getCourses() {
    return courses;
  }

  public void addCourses(Course course) {
    this.courses.add(course);
  }

  @Override
  public String toString() {
    return "Student [name=" + name + "]";
  }
}
