package com.UST.Courses.service;

import com.UST.Courses.exception.CourseNotFoundException;
import com.UST.Courses.feign.StudentClient;
import com.UST.Courses.model.Course;
import com.UST.Courses.model.Student;
import com.UST.Courses.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentClient studentClient;

//    public CourseService(CourseRepository courseRepository, StudentClient studentClient) {
//        this.courseRepository = courseRepository;
//        this.studentClient = studentClient;
//    }

    public Course getCourseById(int id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException("Course with ID " + id + " not found"));
    }

    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    public String assignStudentToCourse(int courseId, int studentId) {
        Course course = getCourseById(courseId);
        Student student = studentClient.getStudentById(studentId);
        return "Student " + student.getName() + " assigned to course " + course.getName();
    }

    public String deleteCourse(int id) {
        courseRepository.deleteById(id);
        return "Deleted Successfully With ID:"+id;
    }
}
