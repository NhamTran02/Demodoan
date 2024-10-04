package com.example.demodoan.service;

import com.example.demodoan.dto.request.CourseDTO;
import com.example.demodoan.exception.ResourceNotFoundException;
import com.example.demodoan.model.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourse();
    Course createCourse(CourseDTO courseDTO) throws ResourceNotFoundException;
    Course updateCourse(Long id, CourseDTO courseDTO);
    void deleteCourse(Long id);
    List<Course> findTitleCourse(String title);
    List<Course> findDescriptionCourse(String description);
}
