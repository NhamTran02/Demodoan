package com.example.demodoan.service.impl;

import com.example.demodoan.dto.request.EnrollmentDTO;
import com.example.demodoan.exception.ErrorCode;
import com.example.demodoan.exception.ResourceNotFoundException;
import com.example.demodoan.model.Course;
import com.example.demodoan.model.Enrollment;
import com.example.demodoan.model.User;
import com.example.demodoan.repository.CourseRepository;
import com.example.demodoan.repository.EnrollmentRepository;
import com.example.demodoan.repository.UserRepository;
import com.example.demodoan.service.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;

    @Override
    public List<Enrollment> getAllEnrollment() {
        return enrollmentRepository.findAll();
    }

    @Override
    public Enrollment createEnrollment(EnrollmentDTO enrollmentDTO) {
        Enrollment enrollment = new Enrollment();

        User user = userRepository.findById(enrollmentDTO.getUser())
                .orElseThrow(()-> new ResourceNotFoundException(ErrorCode.YOU_MUST_LOGIN));
        enrollment.setUser(user);

        Course course = courseRepository.findById(enrollmentDTO.getCourse())
                .orElseThrow(()-> new ResourceNotFoundException(ErrorCode.COURSE_NOT_FOUND));
        enrollment.setCourse(course);
        return enrollmentRepository.save(enrollment);
    }

    @Override
    public Enrollment updateEnrollment(Long id, EnrollmentDTO enrollmentDTO) {
        Optional<Enrollment> optionalEnrollment = enrollmentRepository.findById(id);
        Enrollment enrollment = optionalEnrollment.get();

        User user = userRepository.findById(enrollmentDTO.getUser())
                .orElseThrow(()-> new ResourceNotFoundException(ErrorCode.YOU_MUST_LOGIN));
        enrollment.setUser(user);

        Course course = courseRepository.findById(enrollmentDTO.getCourse())
                .orElseThrow(()-> new ResourceNotFoundException(ErrorCode.COURSE_NOT_FOUND));
        enrollment.setCourse(course);
        return enrollmentRepository.save(enrollment);
    }

    @Override
    public void deleteEnrollment(Long id) {
        enrollmentRepository.deleteById(id);
    }
}
