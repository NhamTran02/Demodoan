package com.example.demodoan.service;

import com.example.demodoan.dto.request.LessonDTO;
import com.example.demodoan.model.Lesson;

import java.util.List;


public interface LessonService {
    List<Lesson> getAllLesson();
    Lesson createLesson(LessonDTO lessonDTO);
    Lesson updateLesson(Long id, LessonDTO lessonDTO);
    void deleteLesson(Long id);
    List<Lesson> findTitleLesson(String title);
}
