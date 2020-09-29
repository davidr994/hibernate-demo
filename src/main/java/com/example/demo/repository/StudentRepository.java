package com.example.demo.repository;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Course;
import com.example.demo.entity.Passport;
import com.example.demo.entity.Student;

@Repository
@Transactional
public class StudentRepository {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    public Student findById(Long id) {
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

    public void deleteById(Long id) {
        Student student = findById(id);
        em.remove(student);
    }

    public void someOperationToUnderstandPersistenceContext() {

        Student student = em.find(Student.class, 2001L);
        Passport passport = student.getPassport();
        passport.setNumber("C1234567");
        student.setName("David - updated");
    }

    public void insertHardcodedStudentAndCourse(){
        Student student = new Student("Gilla");
        Course course = new Course("Microservices Course");
        em.persist(student);
        em.persist(course);

        student.addCourse(course);
        course.addStudent(student);
        em.persist(student);
    }

    public void insertStudentAndCourse(Student student, Course course){
         student.addCourse(course);
        course.addStudent(student);

        em.persist(student);
        em.persist(course);
    }

}
