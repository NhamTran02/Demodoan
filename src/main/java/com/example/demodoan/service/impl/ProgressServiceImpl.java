package com.example.demodoan.service.impl;

import com.example.demodoan.dto.ProgressDTO;
import com.example.demodoan.model.Course;
import com.example.demodoan.model.Lesson;
import com.example.demodoan.model.Progress;
import com.example.demodoan.model.User;
import com.example.demodoan.repository.CourseRepository;
import com.example.demodoan.repository.LessonRepository;
import com.example.demodoan.repository.ProgressRepository;
import com.example.demodoan.repository.UserRepository;
import com.example.demodoan.service.ProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgressServiceImpl implements ProgressService {
    @Autowired
    private ProgressRepository progressRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private LessonRepository lessonRepository;

    @Override
    public List<Progress> getAllProgress() {
        return progressRepository.findAll();
    }

    @Override
    public Progress createProgress(ProgressDTO progressDTO) {
        Progress progress = new Progress();

        progress.setStatus(progressDTO.getStatus());

        User user = userRepository.findById(progressDTO.getUser())
                .orElseThrow(()->new RuntimeException("Bạn chưa đăng nhập"));
        progress.setUser(user);

        Course course = courseRepository.findById(progressDTO.getCourse())
                .orElseThrow(()-> new RuntimeException("Không có khóa học này"));
        progress.setCourse(course);

        Lesson lesson = lessonRepository.findById(progressDTO.getLesson())
                .orElseThrow(()-> new RuntimeException("Không có tiết học này"));
        progress.setLesson(lesson);
        return progressRepository.save(progress);
    }

    @Override
    public Progress updateProgress(Long id, ProgressDTO progressDTO) {
        Optional<Progress> optionalProgress = progressRepository.findById(id);
        Progress progress = optionalProgress.get();

        progress.setStatus(progressDTO.getStatus());

        User user = userRepository.findById(progressDTO.getUser())
                .orElseThrow(()->new RuntimeException("Bạn chưa đăng nhập"));
        progress.setUser(user);

        Course course = courseRepository.findById(progressDTO.getCourse())
                .orElseThrow(()-> new RuntimeException("Không có khóa học này"));
        progress.setCourse(course);

        Lesson lesson = lessonRepository.findById(progressDTO.getLesson())
                .orElseThrow(()-> new RuntimeException("Không có tiết học này"));
        progress.setLesson(lesson);
        return progressRepository.save(progress);
    }

    @Override
    public void deleteProgress(Long id) {
        progressRepository.deleteById(id);
    }
}
