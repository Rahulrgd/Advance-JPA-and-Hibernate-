package com.in28minutes.jpa.hibernate.advancejpa.repository;

import com.in28minutes.jpa.hibernate.advancejpa.entity.Course;
import com.in28minutes.jpa.hibernate.advancejpa.entity.Employee;
import com.in28minutes.jpa.hibernate.advancejpa.entity.FullTimeEmployee;
import com.in28minutes.jpa.hibernate.advancejpa.entity.PartTimeEmployee;
import com.in28minutes.jpa.hibernate.advancejpa.entity.Review;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class EmployeeRepository {

  Logger log = LoggerFactory.getLogger(this.getClass());

  @Autowired
  EntityManager em;

  public Course findById(long id) {
    return em.find(Course.class, id);
  }

  // insert an Employee
  public void insertEmployee(Employee employee){
    em.persist(employee);
  }

  // retrieve all Employee
  public List<PartTimeEmployee> retrieveAllPartTimeEmployee(){
    return em.createQuery("select e from PartTimeEmployee e", PartTimeEmployee.class).getResultList();
  }

  public List<FullTimeEmployee> retrieveAllFullTimeEmployee(){
    return em.createQuery("select e from FullTimeEmployee e", FullTimeEmployee.class).getResultList();
  }
}
