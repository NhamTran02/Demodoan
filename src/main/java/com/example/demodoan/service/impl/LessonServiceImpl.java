package com.example.demodoan.service.impl;

import com.example.demodoan.dto.LessonDTO;
import com.example.demodoan.model.Chapter;
import com.example.demodoan.model.Lesson;
import com.example.demodoan.repository.ChapterRepository;
import com.example.demodoan.repository.LessonRepository;
import com.example.demodoan.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LessonServiceImpl implements LessonService {
    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private ChapterRepository chapterRepository;

    @Override
    public List<Lesson> getAllLesson() {
        return lessonRepository.findAll();
    }

    @Override
    public Lesson createLesson(LessonDTO lessonDTO) {
        Lesson lesson = new Lesson();

        lesson.setTitle(lessonDTO.getTitle());
        lesson.setVideoUrl(lessonDTO.getVideoUrl());

        Chapter chapter = chapterRepository.findById(lessonDTO.getChapter())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy chương"));
        lesson.setChapter(chapter);

        return lessonRepository.save(lesson);
    }

    @Override
    public Lesson updateLesson(Long id, LessonDTO lessonDTO) {
        Optional<Lesson> optionalLesson = lessonRepository.findById(id);
        Lesson lesson = optionalLesson.get();

        lesson.setTitle(lessonDTO.getTitle());
        lesson.setVideoUrl(lessonDTO.getVideoUrl());

        Chapter chapter = chapterRepository.findById(lessonDTO.getChapter())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy chương"));
        lesson.setChapter(chapter);

        return lessonRepository.save(lesson);
    }

    @Override
    public void deleteLesson(Long id) {
        lessonRepository.deleteById(id);
    }

    @Override
    public List<Lesson> findTitleLesson(String title) {
        return lessonRepository.findByTitleContainingIgnoreCase(title);
    }
}
