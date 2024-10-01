package com.example.demodoan.service.impl;

import com.example.demodoan.dto.CourseReviewDTO;
import com.example.demodoan.model.Course;
import com.example.demodoan.model.User;
import com.example.demodoan.repository.CourseRepository;
import com.example.demodoan.repository.CourseReviewRepository;
import com.example.demodoan.repository.UserRepository;
import com.example.demodoan.service.CourseReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseReviewServiceImpl implements CourseReview {
    @Autowired
    private CourseReviewRepository courseReviewRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

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
                .orElseThrow(()-> new RuntimeException("Phải đăng nhập vào tài khoản mới có thể comment"));
        courseReview.setUser(user);

        Course course = courseRepository.findById(courseReviewDTO.getCourse())
                .orElseThrow(()-> new RuntimeException("Không tìm thấy khóa học !"));
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
                .orElseThrow(()-> new RuntimeException("Phải đăng nhập vào tài khoản mới có thể comment"));
        courseReview.setUser(user);

        Course course = courseRepository.findById(courseReviewDTO.getCourse())
                .orElseThrow(()-> new RuntimeException("Không tìm thấy khóa học !"));
        courseReview.setCourse(course);

        return courseReviewRepository.save(courseReview);
    }

    @Override
    public void deleteCourseReview(Long id) {
        courseReviewRepository.deleteById(id);
    }
}
