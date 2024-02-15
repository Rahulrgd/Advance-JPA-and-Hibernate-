package com.in28minutes.jpa.hibernate.advancejpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Course {

  @Id
  @GeneratedValue
  private int id;

  private String name;

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

  public int getId() {
    return id;
  }

  @Override
  public String toString() {
    return "Course [id=" + id + ", name=" + name + "]";
  }
}
