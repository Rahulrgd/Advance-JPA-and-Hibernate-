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
public class Passport {

  @Id
  @GeneratedValue
  private Long id;

  @Column(nullable = false)
  private String number;

  protected Passport() {}

  public Passport(String number) {
    this.number = number;
  }

  public String getNumber() {
    return number;  
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public Long getId() {
    return id;
  }

  @Override
  public String toString() {
    return "Passport [number=" + number + "]";
  }
}
