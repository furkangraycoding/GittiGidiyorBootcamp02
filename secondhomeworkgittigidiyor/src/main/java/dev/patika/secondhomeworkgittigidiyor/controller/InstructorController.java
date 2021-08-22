package dev.patika.secondhomeworkgittigidiyor.controller;

import dev.patika.secondhomeworkgittigidiyor.model.Instructor;
import dev.patika.secondhomeworkgittigidiyor.model.Student;
import dev.patika.secondhomeworkgittigidiyor.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InstructorController {

    InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping("/instructors")
    public ResponseEntity<List<Instructor>> findAll(){
        return new ResponseEntity<>(instructorService.findAll(), HttpStatus.OK);
    }


    @GetMapping("/instructors/{id}")
    public ResponseEntity<Instructor> findInstructorById(@PathVariable int id){

        return new ResponseEntity<>(instructorService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/instructors")
    public Instructor saveInstructor(@RequestBody Instructor instructor){

        return instructorService.save(instructor);

    }
    @DeleteMapping("/instructors")
    public void deleteInstructor(@RequestBody Instructor instructor){

        instructorService.delete(instructor);

    }

    @DeleteMapping("/instructors/{id}")
    public String deleteInstructorById(@PathVariable int id){
        instructorService.deleteById(id);
        return "Deleted...";
    }

    @PutMapping("/instructors")
    public Instructor update(@RequestBody Instructor instructor){
        return instructorService.update(instructor);
    }

    @PutMapping("/instructors/{id}")
    public String updateById(@RequestBody Instructor instructor,@PathVariable int id){
        instructorService.updateById(instructor,id);
        return "Updated...";
    }




}
