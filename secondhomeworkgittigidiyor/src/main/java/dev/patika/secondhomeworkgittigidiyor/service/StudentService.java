package dev.patika.secondhomeworkgittigidiyor.service;

import dev.patika.secondhomeworkgittigidiyor.dao.StudentDAO;
import dev.patika.secondhomeworkgittigidiyor.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService implements BaseService<Student> {

    private StudentDAO studentDAOJPA;

    @Autowired
    public StudentService(@Qualifier("studentDAOJPAImpl") StudentDAO studentDAOJPA) {
        this.studentDAOJPA = studentDAOJPA;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Student> findAll() {
        List<Student> empList = new ArrayList<>();
        Iterable<Student> employeeIter = studentDAOJPA.findAll();
        employeeIter.iterator().forEachRemaining(empList::add);
        return empList;
    }

    @Override
    @Transactional(readOnly = true)
    public Student findById(int id) {
        return (Student) studentDAOJPA.findById(id);
    }

    @Override
    @Transactional
    public Student save(Student student) {

        return (Student) studentDAOJPA.save(student);

    }
    @Override
    @Transactional
    public void delete(Student student) {

        studentDAOJPA.delete(student);

    }

    @Override
    @Transactional
    public void deleteById(int id) {
        studentDAOJPA.deleteById(id);
    }

    @Override
    public Student update(Student student) {
        return (Student) studentDAOJPA.update(student);
    }

    @Override
    public void updateById(Student student,int id) {
        studentDAOJPA.updateById(student,id);
    }
}
