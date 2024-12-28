package com.UST.Courses.feign;

import com.UST.Courses.config.FeignClientConfig;
import com.UST.Courses.model.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "Student", configuration = FeignClientConfig.class)
public interface StudentClient {
    @GetMapping("/students/{id}")
    Student getStudentById(@PathVariable int id);



}
