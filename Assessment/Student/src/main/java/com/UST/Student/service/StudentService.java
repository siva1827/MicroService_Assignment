package com.UST.Student.service;

import com.UST.Student.exception.StudentNotFoundException;
import com.UST.Student.model.Student;
import com.UST.Student.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepository;

//   //public StudentService(StudentRepo studentRepository) {
//        this.studentRepository = studentRepository;
//    }

    public Student getStudentById(int id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student with ID " + id + " not found"));

    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public String deleteCourse(int id) {
        studentRepository.deleteById(id);
        return "Deleted Successfully With ID:"+id;
    }
}
