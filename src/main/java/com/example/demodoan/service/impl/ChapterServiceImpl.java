package com.example.demodoan.service.impl;

import com.example.demodoan.dto.ChapterDTO;
import com.example.demodoan.model.Chapter;
import com.example.demodoan.model.Course;
import com.example.demodoan.repository.ChapterRepository;
import com.example.demodoan.repository.CourseRepository;
import com.example.demodoan.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChapterServiceImpl implements ChapterService {
    @Autowired
    private ChapterRepository chapterRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Chapter> getAllChapters() {
        return chapterRepository.findAll();
    }

    @Override
    public Chapter createChapter(ChapterDTO chapterDTO) {
        Chapter chapter = new Chapter();

        chapter.setName(chapterDTO.getName());
        chapter.setQuantity(chapter.getQuantity());

        Course course = courseRepository.findById(chapterDTO.getCourse())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy khóa học này"));
        chapter.setCourse(course);
        return chapterRepository.save(chapter);
    }

    @Override
    public Chapter updateChapter(Long id, ChapterDTO chapterDTO) {
        Optional<Chapter> optionalChapter = chapterRepository.findById(id);
        Chapter chapter = optionalChapter.get();

        chapter.setName(chapterDTO.getName());
        chapter.setQuantity(chapterDTO.getQuantity());

        Course course = courseRepository.findById(chapterDTO.getCourse())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy khóa học này"));
        chapter.setCourse(course);
        return chapterRepository.save(chapter);
    }

    @Override
    public void deleteChapter(Long id) {
        chapterRepository.deleteById(id);
    }

    @Override
    public List<Chapter> findNameChapter(String name) {
        return chapterRepository.findByNameContainingIgnoreCase(name);
    }
}
