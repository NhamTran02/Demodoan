package com.example.demodoan.controller;

import com.example.demodoan.dto.request.LessonDTO;
import com.example.demodoan.model.Lesson;
import com.example.demodoan.service.LessonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/lesson")
public class LessonController {
    @Autowired
    private LessonService lessonService;

    @PostMapping
    Lesson createLesson(@Valid  @RequestBody LessonDTO lessonDTO){
        return lessonService.createLesson(lessonDTO);
    }

    @GetMapping
    List<Lesson> getAllLesson(){
        return lessonService.getAllLesson();
    }

    @PutMapping("/{id}")
    Lesson updateLesson (@PathVariable Long id,@Valid @RequestBody LessonDTO lessonDTO){
        return lessonService.updateLesson(id, lessonDTO);
    }

    @DeleteMapping("/{id}")
    String deleteLesson(@PathVariable Long id){
        lessonService.deleteLesson(id);
        return "Xóa thành công";
    }

    @GetMapping("/{title}")
    List<Lesson> findTitleLesson (@PathVariable String title){
        return lessonService.findTitleLesson(title);
    }
}
