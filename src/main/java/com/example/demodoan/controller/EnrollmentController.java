package com.example.demodoan.controller;

import com.example.demodoan.dto.request.EnrollmentDTO;
import com.example.demodoan.model.Enrollment;
import com.example.demodoan.service.EnrollmentService;
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
    private EnrollmentService enrollmentService;

    @PostMapping
    Enrollment createEnrollment(@RequestBody EnrollmentDTO enrollmentDTO){
        return enrollmentService.createEnrollment(enrollmentDTO);
    }

    @GetMapping
    List<Enrollment> getAllEnrollment(){
        return enrollmentService.getAllEnrollment();
    }

    @PutMapping("/{id}")
    Enrollment updateEnrollment (@PathVariable Long id,@Valid @RequestBody EnrollmentDTO enrollmentDTO){
        return enrollmentService.updateEnrollment(id, enrollmentDTO);
    }

    @DeleteMapping("/{id}")
    String deleteEnrollment(@PathVariable Long id){
        enrollmentService.deleteEnrollment(id);
        return "Xóa thành công";
    }
}
