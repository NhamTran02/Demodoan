package com.example.demodoan.service;


import com.example.demodoan.dto.EnrollmentDTO;
import com.example.demodoan.model.Enrollment;

import java.util.List;

public interface EnrollmentService {
    List<Enrollment> getAllEnrollment();
    Enrollment createEnrollment(EnrollmentDTO enrollmentDTO);
    Enrollment updateEnrollment(Long id, EnrollmentDTO enrollmentDTO);
    void deleteEnrollment(Long id);
}
