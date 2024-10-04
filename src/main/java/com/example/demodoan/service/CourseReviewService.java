package com.example.demodoan.service;

 import com.example.demodoan.dto.request.CourseReviewDTO;

 import java.util.List;


public interface CourseReviewService {
    List<com.example.demodoan.model.CourseReview> getAllCourseReview();
    com.example.demodoan.model.CourseReview createCourseReview(CourseReviewDTO courseReviewDTO);
    com.example.demodoan.model.CourseReview updateCourseReview(Long id, CourseReviewDTO courseReviewDTO);
    void deleteCourseReview(Long id);
}
