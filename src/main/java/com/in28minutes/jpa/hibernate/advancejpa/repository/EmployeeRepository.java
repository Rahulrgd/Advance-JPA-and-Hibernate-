package com.in28minutes.jpa.hibernate.advancejpa.repository;

import com.in28minutes.jpa.hibernate.advancejpa.entity.Course;
import com.in28minutes.jpa.hibernate.advancejpa.entity.Employee;
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
  public List<Employee> retrieveAllEmployee(){
    return em.createQuery("select e from Employee e", Employee.class).getResultList();
  }
}
