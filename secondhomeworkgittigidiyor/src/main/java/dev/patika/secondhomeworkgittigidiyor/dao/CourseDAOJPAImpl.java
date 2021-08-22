package dev.patika.secondhomeworkgittigidiyor.dao;

import dev.patika.secondhomeworkgittigidiyor.model.Course;
import dev.patika.secondhomeworkgittigidiyor.model.Instructor;
import dev.patika.secondhomeworkgittigidiyor.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CourseDAOJPAImpl implements CourseDAO<Course> {

    private EntityManager entityManager;
    @Autowired
    public CourseDAOJPAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Course> findAll() {
        return entityManager.createQuery("select s from Course s",Course.class).getResultList();
    }

    @Override
    public Course findById(int id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    @Transactional
    public Course save(Course course) {

        return entityManager.merge(course);

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
        course1.setInstructor(course.getInstructor());
        course1.setStudentList(course.getStudentList());
        entityManager.merge(course1);
    }
}
