package com.in28minutes.jpa.hibernate.advancejpa.entity;

import java.math.BigDecimal;

public class PartTimeEmployee extends Employee {

  private BigDecimal hourlyWage;

  protected PartTimeEmployee() {}

  public PartTimeEmployee(String name, BigDecimal hourlyWage) {
    super(name);
    this.hourlyWage = hourlyWage;
  }
}
