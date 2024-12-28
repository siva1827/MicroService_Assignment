package com.UST.Courses.controller;

import com.UST.Courses.model.Course;
import com.UST.Courses.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

//    //public CourseController(CourseService courseService) {
//        this.courseService = courseService;
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable int id) {
        return ResponseEntity.ok(courseService.getCourseById(id));
    }

    @GetMapping("getAllCourses")
    public ResponseEntity<List<Course>> getAllCourses(){
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    @PostMapping("/save")
    public ResponseEntity<Course> saveCourse(@RequestBody Course course) {
        return ResponseEntity.status(HttpStatus.CREATED).body(courseService.saveCourse(course));
    }

    @DeleteMapping("/deleteCourse")
    public ResponseEntity<String> deleteCourse(@RequestBody int id){
        return ResponseEntity.ok(courseService.deleteCourse(id));
    }

    @PostMapping("/{courseId}/assign-student/{studentId}")
    public ResponseEntity<String> assignStudentToCourse(
            @PathVariable int courseId, @PathVariable int studentId) {
        return ResponseEntity.ok(courseService.assignStudentToCourse(courseId, studentId));
    }
}
