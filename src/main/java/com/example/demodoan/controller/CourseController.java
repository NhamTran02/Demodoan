package com.example.demodoan.controller;

import com.example.demodoan.dto.request.CourseDTO;
import com.example.demodoan.model.Course;
import com.example.demodoan.service.CourseService;
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
    private CourseService courseService;

    @PostMapping
    Course createCourse(@Valid @RequestBody CourseDTO courseDTO) {
        return courseService.createCourse(courseDTO);
    }

    @GetMapping
    List<Course> getAllCourse(){
        return courseService.getAllCourse();
    }

    @PutMapping("/{id}")
    Course updateCourse (@PathVariable Long id,@Valid @RequestBody CourseDTO courseDTO){
        return courseService.updateCourse(id, courseDTO);
    }

    @DeleteMapping("/{id}")
    String deleteCourse(@PathVariable Long id){
        courseService.deleteCourse(id);
        return "Xóa thành công";
    }

    @GetMapping("/{title}")
    List<Course> findTitleCourse (@PathVariable String title){
        return courseService.findTitleCourse(title);
    }

    @GetMapping("/{description}")
    List<Course> findDescriptionCourse (@PathVariable String description){
        return courseService.findDescriptionCourse(description);
    }
}
