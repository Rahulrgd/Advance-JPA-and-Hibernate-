package com.in28minutes.jpa.hibernate.advancejpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Employee {

  @Id
  @GeneratedValue
  private Long id;

  @Column(name = "fullname", nullable = false)
  private String name;

  protected Employee() {}

  public Employee(String name) {
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
    return "Employee [name=" + name + "]";
  }
}
