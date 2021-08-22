package dev.patika.secondhomeworkgittigidiyor.service;

import dev.patika.secondhomeworkgittigidiyor.dao.CourseDAO;
import dev.patika.secondhomeworkgittigidiyor.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService implements BaseService<Course> {

    private CourseDAO courseDAOJPA;

    @Autowired
    public CourseService(@Qualifier("courseDAOJPAImpl") CourseDAO courseDAOJPA) {
        this.courseDAOJPA = courseDAOJPA;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Course> findAll() {
        List<Course> empList = new ArrayList<>();
        Iterable<Course> employeeIter = courseDAOJPA.findAll();
        employeeIter.iterator().forEachRemaining(empList::add);
        return empList;
    }

    @Override
    @Transactional(readOnly = true)
    public Course findById(int id) {
        return (Course) courseDAOJPA.findById(id);
    }

    @Override
    @Transactional
    public Course save(Course course) {

        return (Course) courseDAOJPA.save(course);

    }
    @Override
    @Transactional
    public void delete(Course course) {

        courseDAOJPA.delete(course);

    }

    @Override
    @Transactional
    public void deleteById(int id) {
        courseDAOJPA.deleteById(id);
    }

    @Override
    public Course update(Course course) {
        return (Course) courseDAOJPA.update(course);
    }

    @Override
    public void updateById(Course course,int id) {
         courseDAOJPA.updateById(course,id);
    }

}
