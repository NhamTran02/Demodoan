package com.example.demodoan.service.impl;

import com.example.demodoan.dto.CourseDTO;
import com.example.demodoan.model.Category;
import com.example.demodoan.model.Course;
import com.example.demodoan.repository.CategoryRepository;
import com.example.demodoan.repository.CourseRepository;
import com.example.demodoan.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    @Override
    public Course createCourse(CourseDTO courseDTO) {
        Course course = new Course();

        course.setTitle(courseDTO.getTitle());
        course.setDescription(courseDTO.getDescription());
        course.setImage(courseDTO.getImage());

        Category category = categoryRepository.findById(courseDTO.getCategory())
                .orElseThrow(()-> new RuntimeException("Không tìm thấy loại khóa học!"));
        course.setCategory(category);

        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Long id, CourseDTO courseDTO) {
        Optional<Course> optionalCourse = courseRepository.findById(id);

        Course course = optionalCourse.get();

        course.setTitle(courseDTO.getTitle());
        course.setDescription(courseDTO.getDescription());
        course.setImage(courseDTO.getImage());

        Category category = categoryRepository.findById(courseDTO.getCategory())
                .orElseThrow(()-> new RuntimeException("Không tìm thấy loại khóa học!"));
        course.setCategory(category);

        return courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public List<Course> findTitleCourse(String title) {
        return courseRepository.findByTitleContainingIgnoreCase(title);
    }

    @Override
    public List<Course> findDescriptionCourse(String description) {
        return courseRepository.findByDescriptionContainingIgnoreCase(description);
    }
}
