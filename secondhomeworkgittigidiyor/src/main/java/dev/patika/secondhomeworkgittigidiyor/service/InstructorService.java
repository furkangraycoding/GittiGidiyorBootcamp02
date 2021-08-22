package dev.patika.secondhomeworkgittigidiyor.service;

import dev.patika.secondhomeworkgittigidiyor.dao.InstructorDAO;
import dev.patika.secondhomeworkgittigidiyor.model.Course;
import dev.patika.secondhomeworkgittigidiyor.model.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InstructorService implements BaseService<Instructor> {

    private InstructorDAO instructorDAOJPA;

    @Autowired
    public InstructorService(@Qualifier("instructorDAOJPAImpl") InstructorDAO instructorDAOJPA) {
        this.instructorDAOJPA = instructorDAOJPA;
    }

    @Override
    public List<Instructor> findAll() {
        return instructorDAOJPA.findAll();
    }

    @Override
    public Instructor findById(int id) {
        return (Instructor) instructorDAOJPA.findById(id);
    }

    @Override
    @Transactional
    public Instructor save(Instructor instructor) {

        return (Instructor) instructorDAOJPA.save(instructor);

    }
    @Override
    @Transactional
    public void delete(Instructor instructor) {

        instructorDAOJPA.delete(instructor);

    }

    @Override
    @Transactional
    public void deleteById(int id) {
        instructorDAOJPA.deleteById(id);
    }

    @Override
    public Instructor update(Instructor instructor) {
        return (Instructor) instructorDAOJPA.update(instructor);
    }

    @Override
    public void updateById(Instructor instructor, int id) {
        instructorDAOJPA.updateById(instructor,id);
    }

}
