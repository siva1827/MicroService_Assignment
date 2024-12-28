package com.UST.Student.controller;

import com.UST.Student.model.Student;
import com.UST.Student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    public StudentService studentService;


    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable int id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PostMapping("/addStudent")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.saveStudent(student));
    }

    @DeleteMapping("DeleteStudent")
    public ResponseEntity<String> deleteStudent(@RequestBody int id){
        return ResponseEntity.ok(studentService.deleteCourse(id));
    }

    @GetMapping("/getAllStudents")
    public ResponseEntity<List<Student>> getAllStudents(){
        return ResponseEntity.ok(studentService.getAllStudents());
    }
}
