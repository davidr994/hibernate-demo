package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Course;
import com.example.demo.entity.Review;
import com.example.demo.entity.ReviewRating;

@Repository
@Transactional
public class CourseRepository {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EntityManager em;

    public Course findById(Long id) {
        Course course = em.find(Course.class, id);
        logger.info("Course -> {}", course);
        return course;
    }

    public Course save(Course course) {

        if (course.getId() == null) {
            em.persist(course);
        } else {
            em.merge(course);
        }

        return course;
    }

    public void deleteById(Long id) {
        Course course = findById(id);
        em.remove(course);
    }

    public void playWithEntityManager() {
        Course course1 = new Course("Web Services");
        em.persist(course1);

        Course course2 = findById(10001L);

        course2.setName("JPA Course - Updated");

    }

    public void addHardcodedReviewsForCourse() {

        Course course = findById(10003L);
        logger.info("course.getReviews() -> {}", course.getReviews());


        Review review1 = new Review(ReviewRating.FIVE, "i love this course");

        course.addReview(review1);
        review1.setCourse(course);

        em.persist(review1);

    }

    public void addReviewsForCourse(Long courseId, List<Review> reviews) {
        Course course = findById(courseId);
        logger.info("course.getReviews() -> {}", course.getReviews());
        for(Review review:reviews)
        {
            course.addReview(review);
            review.setCourse(course);
            em.persist(review);
        }
    }
}
