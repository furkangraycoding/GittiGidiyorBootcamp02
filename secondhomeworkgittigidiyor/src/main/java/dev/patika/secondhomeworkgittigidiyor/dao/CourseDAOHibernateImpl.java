package dev.patika.secondhomeworkgittigidiyor.dao;

import dev.patika.secondhomeworkgittigidiyor.model.Course;
import dev.patika.secondhomeworkgittigidiyor.model.Instructor;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;


@Repository
public class CourseDAOHibernateImpl implements CourseDAO<Course>{


    private EntityManager entityManager;

    @Autowired
    public CourseDAOHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Course> findAll() {
        Session session= entityManager.unwrap(Session.class);

        return session.createQuery("from Course ",Course.class).getResultList();
    }

    @Override
    public Course findById(int id) {
        return null;
    }

    @Override
    public Course save(Course course) {
        Session session= entityManager.unwrap(Session.class);
        return (Course) session.merge(course);
    }

    @Override
    @Transactional
    public void delete(Course course) {
        int id=course.getId();
        Course course1 = this.findById(id);
        entityManager.remove(course1);

    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Course course = this.findById(id);

        entityManager.remove(course);
    }

    @Override
    @Transactional
    public Course update(Course course) {
        return entityManager.merge(course);
    }

    @Override
    @Transactional
    public void updateById(Course course,int id) {
        Course course1 = this.findById(id);
        course1.setCourseCode(course.getCourseCode());
        course1.setCourseName(course.getCourseName());
        course1.setCredit(course.getCredit());
        entityManager.merge(course1);
    }
}
