package dev.patika.secondhomeworkgittigidiyor.dao;

import dev.patika.secondhomeworkgittigidiyor.model.Student;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;


@Repository
public class StudentDAOHibernateImpl implements StudentDAO<Student>{


    private EntityManager entityManager;

    @Autowired
    public StudentDAOHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Student> findAll() {
        Session session= entityManager.unwrap(Session.class);

        return session.createQuery("select s from Student s",Student.class).getResultList();
    }

    @Override
    public Student findById(int id) {
        return null;
    }

    @Override
    public Student save(Student student) {
        Session session= entityManager.unwrap(Session.class);
        return (Student) session.merge(student);
    }
    @Override
    @Transactional
    public void delete(Student student) {
        int id=student.getId();
        Student student1 = this.findById(id);
        entityManager.remove(student1);

    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Student student = this.findById(id);

        entityManager.remove(student);
    }

    @Override
    @Transactional
    public Student update(Student student) {
        return entityManager.merge(student);
    }
    @Override
    @Transactional
    public void updateById(Student student,int id) {
        Student student1 = this.findById(id);
        student1.setAddress(student.getAddress());
        student1.setName(student.getName());
        student1.setBirthDate(student.getBirthDate());
        student1.setGender(student.getGender());

        entityManager.merge(student1);
    }
}
