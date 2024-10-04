package com.example.demodoan.controller;

import com.example.demodoan.dto.request.CourseReviewDTO;
import com.example.demodoan.model.CourseReview;
import com.example.demodoan.service.CourseReviewService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/courseReview")
public class CourseReviewController {
    @Autowired
    private CourseReviewService courseReviewService;

    @PostMapping
    CourseReview createCourseReview(@Valid @RequestBody CourseReviewDTO courseReviewDTO){
        return courseReviewService.createCourseReview(courseReviewDTO);
    }

    @GetMapping
    List<CourseReview> getAllCourseReview(){
        return courseReviewService.getAllCourseReview();
    }

    @PutMapping("/{id}")
    CourseReview updateCourseReview (@PathVariable Long id,@Valid @RequestBody CourseReviewDTO courseReviewDTO){
        return courseReviewService.updateCourseReview(id, courseReviewDTO);
    }

    @DeleteMapping("/{id}")
    String deleteCourseReview(@PathVariable Long id){
        courseReviewService.deleteCourseReview(id);
        return "Xóa thành công";
    }
}
