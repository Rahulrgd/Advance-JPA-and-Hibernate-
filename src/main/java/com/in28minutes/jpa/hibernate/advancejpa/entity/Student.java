package com.in28minutes.jpa.hibernate.advancejpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Student {

  @Id
  @GeneratedValue
  private Long id;

  @Column(nullable = false)
  private String name;

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

  @Override
  public String toString() {
    return "Student [name=" + name + "]";
  }
}
