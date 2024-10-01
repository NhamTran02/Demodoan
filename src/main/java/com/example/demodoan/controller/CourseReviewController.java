package com.example.demodoan.controller;

import com.example.demodoan.dto.CourseReviewDTO;
import com.example.demodoan.model.CourseReview;
import com.example.demodoan.service.impl.CourseReviewServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/courseReview")
public class CourseReviewController {
    @Autowired
    private CourseReviewServiceImpl courseReviewServiceImpl;

    @PostMapping
    CourseReview createCourseReview(@RequestBody CourseReviewDTO courseReviewDTO){
        return courseReviewServiceImpl.createCourseReview(courseReviewDTO);
    }

    @GetMapping
    List<CourseReview> getAllCourseReview(){
        return courseReviewServiceImpl.getAllCourseReview();
    }

    @PutMapping("/{id}")
    CourseReview updateCourseReview (@PathVariable Long id, @RequestBody CourseReviewDTO courseReviewDTO){
        return courseReviewServiceImpl.updateCourseReview(id, courseReviewDTO);
    }

    @DeleteMapping("/{id}")
    String deleteCourseReview(@PathVariable Long id){
        courseReviewServiceImpl.deleteCourseReview(id);
        return "Xóa thành công";
    }
}
