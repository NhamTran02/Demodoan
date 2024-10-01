package com.example.demodoan.repository;

import com.example.demodoan.model.Chapter;
import com.example.demodoan.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByTitleContainingIgnoreCase(String title);
    List<Course> findByDescriptionContainingIgnoreCase(String description);
}
