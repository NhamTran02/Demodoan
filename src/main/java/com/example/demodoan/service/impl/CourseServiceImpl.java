package com.example.demodoan.service.impl;

import com.example.demodoan.dto.request.CourseDTO;
import com.example.demodoan.exception.ErrorCode;
import com.example.demodoan.exception.ResourceNotFoundException;
import com.example.demodoan.model.Category;
import com.example.demodoan.model.Course;
import com.example.demodoan.repository.CategoryRepository;
import com.example.demodoan.repository.CourseRepository;
import com.example.demodoan.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final CategoryRepository categoryRepository;

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
                .orElseThrow(()-> new ResourceNotFoundException(ErrorCode.CATEGORY_NOT_FOUND));
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
                .orElseThrow(()-> new ResourceNotFoundException(ErrorCode.COURSE_NOT_FOUND));
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
