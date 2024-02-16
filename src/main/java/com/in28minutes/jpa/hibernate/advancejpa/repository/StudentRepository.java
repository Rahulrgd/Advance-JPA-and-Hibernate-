package com.in28minutes.jpa.hibernate.advancejpa.repository;

import com.in28minutes.jpa.hibernate.advancejpa.entity.Passport;
import com.in28minutes.jpa.hibernate.advancejpa.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class StudentRepository {

  Logger log = LoggerFactory.getLogger(this.getClass());

  @Autowired
  EntityManager em;

  public Student findById(long id) {
    return em.find(Student.class, id);
  }

  public Student save(Student student) {
    if (student.getId() == null) {
      em.persist(student);
    } else {
      em.merge(student);
    }

    return student;
  }

  public void deleteById(long id) {
    Student student = em.find(Student.class, id);
    em.remove(student);
  }

  public void saveStudentWithPassport() {
    Passport passport = new Passport("Z123456");
    em.persist(passport);
    Student student = new Student("Mike");
    student.setPassport(passport);
    em.persist(student);
  }
}
