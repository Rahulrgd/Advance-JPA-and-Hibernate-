package com.in28minutes.jpa.hibernate.advancejpa.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.in28minutes.jpa.hibernate.advancejpa.entity.Course;

import jakarta.persistence.EntityManager;

@Repository
public class CourseRepository {
    
    @Autowired
    EntityManager em;

    public Course findById(long id){
        return em.find(Course.class, id);
    }
}
