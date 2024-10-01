package com.example.demodoan.controller;

import com.example.demodoan.dto.EnrollmentDTO;
import com.example.demodoan.model.Enrollment;
import com.example.demodoan.service.impl.EnrollmentServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/enrollment")
public class EnrollmentController {
    @Autowired
    private EnrollmentServiceImpl enrollmentServiceImpl;

    @PostMapping
    Enrollment createEnrollment(@RequestBody EnrollmentDTO enrollmentDTO){
        return enrollmentServiceImpl.createEnrollment(enrollmentDTO);
    }

    @GetMapping
    List<Enrollment> getAllEnrollment(){
        return enrollmentServiceImpl.getAllEnrollment();
    }

    @PutMapping("/{id}")
    Enrollment updateEnrollment (@PathVariable Long id,@Valid @RequestBody EnrollmentDTO enrollmentDTO){
        return enrollmentServiceImpl.updateEnrollment(id, enrollmentDTO);
    }

    @DeleteMapping("/{id}")
    String deleteEnrollment(@PathVariable Long id){
        enrollmentServiceImpl.deleteEnrollment(id);
        return "Xóa thành công";
    }
}
