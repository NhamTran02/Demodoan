package com.example.demodoan.service.impl;

import com.example.demodoan.dto.EnrollmentDTO;
import com.example.demodoan.model.Course;
import com.example.demodoan.model.Enrollment;
import com.example.demodoan.model.User;
import com.example.demodoan.repository.CourseRepository;
import com.example.demodoan.repository.EnrollmentRepository;
import com.example.demodoan.repository.UserRepository;
import com.example.demodoan.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {
    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Enrollment> getAllEnrollment() {
        return enrollmentRepository.findAll();
    }

    @Override
    public Enrollment createEnrollment(EnrollmentDTO enrollmentDTO) {
        Enrollment enrollment = new Enrollment();

        User user = userRepository.findById(enrollmentDTO.getUser())
                .orElseThrow(()-> new RuntimeException("Bạn phải đăng nhập"));
        enrollment.setUser(user);

        Course course = courseRepository.findById(enrollmentDTO.getCourse())
                .orElseThrow(()-> new RuntimeException("Khóa học khôn tồn tại"));
        enrollment.setCourse(course);
        return enrollmentRepository.save(enrollment);
    }

    @Override
    public Enrollment updateEnrollment(Long id, EnrollmentDTO enrollmentDTO) {
        Optional<Enrollment> optionalEnrollment = enrollmentRepository.findById(id);
        Enrollment enrollment = optionalEnrollment.get();

        User user = userRepository.findById(enrollmentDTO.getUser())
                .orElseThrow(()-> new RuntimeException("Bạn phải đăng nhập"));
        enrollment.setUser(user);

        Course course = courseRepository.findById(enrollmentDTO.getCourse())
                .orElseThrow(()-> new RuntimeException("Khóa học khôn tồn tại"));
        enrollment.setCourse(course);
        return enrollmentRepository.save(enrollment);
    }

    @Override
    public void deleteEnrollment(Long id) {
        enrollmentRepository.deleteById(id);
    }
}
