package com.example.demodoan.service.impl;

import com.example.demodoan.dto.request.ProgressDTO;
import com.example.demodoan.exception.ErrorCode;
import com.example.demodoan.exception.ResourceNotFoundException;
import com.example.demodoan.model.Course;
import com.example.demodoan.model.Lesson;
import com.example.demodoan.model.Progress;
import com.example.demodoan.model.User;
import com.example.demodoan.repository.CourseRepository;
import com.example.demodoan.repository.LessonRepository;
import com.example.demodoan.repository.ProgressRepository;
import com.example.demodoan.repository.UserRepository;
import com.example.demodoan.service.ProgressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProgressServiceImpl implements ProgressService {
    private final ProgressRepository progressRepository;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;
    private final LessonRepository lessonRepository;

    @Override
    public List<Progress> getAllProgress() {
        return progressRepository.findAll();
    }

    @Override
    public Progress createProgress(ProgressDTO progressDTO) {
        Progress progress = new Progress();

        progress.setStatus(progressDTO.getStatus());

        User user = userRepository.findById(progressDTO.getUser())
                .orElseThrow(()->new ResourceNotFoundException(ErrorCode.YOU_MUST_LOGIN));
        progress.setUser(user);

        Course course = courseRepository.findById(progressDTO.getCourse())
                .orElseThrow(()-> new ResourceNotFoundException(ErrorCode.COURSE_NOT_FOUND));
        progress.setCourse(course);

        Lesson lesson = lessonRepository.findById(progressDTO.getLesson())
                .orElseThrow(()-> new ResourceNotFoundException(ErrorCode.LESSON_NOT_FOUND));
        progress.setLesson(lesson);
        return progressRepository.save(progress);
    }

    @Override
    public Progress updateProgress(Long id, ProgressDTO progressDTO) {
        Optional<Progress> optionalProgress = progressRepository.findById(id);
        Progress progress = optionalProgress.get();

        progress.setStatus(progressDTO.getStatus());

        User user = userRepository.findById(progressDTO.getUser())
                .orElseThrow(()->new ResourceNotFoundException(ErrorCode.YOU_MUST_LOGIN));
        progress.setUser(user);

        Course course = courseRepository.findById(progressDTO.getCourse())
                .orElseThrow(()-> new ResourceNotFoundException(ErrorCode.COURSE_NOT_FOUND));
        progress.setCourse(course);

        Lesson lesson = lessonRepository.findById(progressDTO.getLesson())
                .orElseThrow(()-> new ResourceNotFoundException(ErrorCode.LESSON_NOT_FOUND));
        progress.setLesson(lesson);
        return progressRepository.save(progress);
    }

    @Override
    public void deleteProgress(Long id) {
        progressRepository.deleteById(id);
    }
}
