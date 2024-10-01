package com.example.demodoan.service;

import com.example.demodoan.dto.ChapterDTO;
import com.example.demodoan.dto.CourseDTO;
import com.example.demodoan.model.Chapter;
import com.example.demodoan.model.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourse();
    Course createCourse(CourseDTO courseDTO);
    Course updateCourse(Long id, CourseDTO courseDTO);
    void deleteCourse(Long id);
    List<Course> findTitleCourse(String title);
    List<Course> findDescriptionCourse(String description);
}
