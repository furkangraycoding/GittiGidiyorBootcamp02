package dev.patika.secondhomeworkgittigidiyor.controller;

import dev.patika.secondhomeworkgittigidiyor.model.Course;
import dev.patika.secondhomeworkgittigidiyor.model.Student;
import dev.patika.secondhomeworkgittigidiyor.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> findAll(){

        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> findCourseById(@PathVariable int id){

        return new ResponseEntity<>(studentService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/students")
    public Student saveStudent(@RequestBody Student student){

        return studentService.save(student);

    }
    @DeleteMapping("/students")
    public void deleteStudent(@RequestBody Student student){

        studentService.delete(student);

    }

    @DeleteMapping("/students/{id}")
    public String deleteStudentById(@PathVariable int id){
        studentService.deleteById(id);
        return "Deleted...";
    }

    @PutMapping("/students")
    public Student update(@RequestBody Student student){
        return studentService.update(student);
    }

    @PutMapping("/students/{id}")
    public String updateById(@RequestBody Student student, @PathVariable int id){
        studentService.updateById(student,id);
        return "Updated...";
    }




}
