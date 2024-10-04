package com.example.demodoan.service.impl;

import com.example.demodoan.dto.request.CourseReviewDTO;
import com.example.demodoan.exception.ErrorCode;
import com.example.demodoan.exception.ResourceNotFoundException;
import com.example.demodoan.model.Course;
import com.example.demodoan.model.User;
import com.example.demodoan.repository.CourseRepository;
import com.example.demodoan.repository.CourseReviewRepository;
import com.example.demodoan.repository.UserRepository;
import com.example.demodoan.service.CourseReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseReviewServiceImpl implements CourseReviewService {
    private final CourseReviewRepository courseReviewRepository;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;

    @Override
    public List<com.example.demodoan.model.CourseReview> getAllCourseReview() {
        return courseReviewRepository.findAll();
    }

    @Override
    public com.example.demodoan.model.CourseReview createCourseReview(CourseReviewDTO courseReviewDTO) {
        com.example.demodoan.model.CourseReview courseReview = new com.example.demodoan.model.CourseReview();

        courseReview.setRating(courseReviewDTO.getRating());
        courseReview.setComment(courseReviewDTO.getComment());

        User user = userRepository.findById(courseReviewDTO.getUser())
                .orElseThrow(()-> new ResourceNotFoundException(ErrorCode.YOU_MUST_LOGIN));
        courseReview.setUser(user);

        Course course = courseRepository.findById(courseReviewDTO.getCourse())
                .orElseThrow(()-> new ResourceNotFoundException(ErrorCode.COURSE_NOT_FOUND));
        courseReview.setCourse(course);

        return courseReviewRepository.save(courseReview);
    }

    @Override
    public com.example.demodoan.model.CourseReview updateCourseReview(Long id, CourseReviewDTO courseReviewDTO) {
        Optional<com.example.demodoan.model.CourseReview> optionalCourseReview = courseReviewRepository.findById(id);

        com.example.demodoan.model.CourseReview courseReview = optionalCourseReview.get();

        courseReview.setRating(courseReviewDTO.getRating());
        courseReview.setComment(courseReviewDTO.getComment());

        User user = userRepository.findById(courseReviewDTO.getUser())
                .orElseThrow(()-> new ResourceNotFoundException(ErrorCode.YOU_MUST_LOGIN));
        courseReview.setUser(user);

        Course course = courseRepository.findById(courseReviewDTO.getCourse())
                .orElseThrow(()-> new ResourceNotFoundException(ErrorCode.COURSE_NOT_FOUND));
        courseReview.setCourse(course);

        return courseReviewRepository.save(courseReview);
    }

    @Override
    public void deleteCourseReview(Long id) {
        courseReviewRepository.deleteById(id);
    }
}
