package com.example.demodoan.controller;

import com.example.demodoan.dto.CourseDTO;
import com.example.demodoan.exception.ResourceNotFoundException;
import com.example.demodoan.model.Course;
import com.example.demodoan.service.impl.CourseServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseServiceImpl courseServiceImpl;

    @PostMapping
    Course createCourse(@Valid @RequestBody CourseDTO courseDTO) {
        return courseServiceImpl.createCourse(courseDTO);
    }

    @GetMapping
    List<Course> getAllCourse(){
        return courseServiceImpl.getAllCourse();
    }

    @PutMapping("/{id}")
    Course updateCourse (@PathVariable Long id,@Valid @RequestBody CourseDTO courseDTO){
        return courseServiceImpl.updateCourse(id, courseDTO);
    }

    @DeleteMapping("/{id}")
    String deleteCourse(@PathVariable Long id){
        courseServiceImpl.deleteCourse(id);
        return "Xóa thành công";
    }

    @GetMapping("/{title}")
    List<Course> findTitleCourse (@PathVariable String title){
        return courseServiceImpl.findTitleCourse(title);
    }

    @GetMapping("/{description}")
    List<Course> findDescriptionCourse (@PathVariable String description){
        return courseServiceImpl.findDescriptionCourse(description);
    }
}
