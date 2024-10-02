package com.example.demodoan.service.impl;

import com.example.demodoan.dto.QuizzeDTO;
import com.example.demodoan.exception.ErrorCode;
import com.example.demodoan.exception.ResourceNotFoundException;
import com.example.demodoan.model.Course;
import com.example.demodoan.model.Quizze;
import com.example.demodoan.repository.CourseRepository;
import com.example.demodoan.repository.QuizzeRepository;
import com.example.demodoan.service.QuizzeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuizzeServiceImpl implements QuizzeService {
    private final QuizzeRepository quizzeRepository;
    private final CourseRepository courseRepository;

    @Override
    public Quizze createQuizze(QuizzeDTO quizzeDTO) {
        Course course=courseRepository.findById(quizzeDTO.getCourse())
                .orElseThrow(()-> new ResourceNotFoundException(ErrorCode.COURSE_NOT_FOUND));
        Quizze quizze = Quizze.builder()
                .title(quizzeDTO.getTitle())
                .questions(quizzeDTO.getQuestions())
                .course(course)
                .build();
        return quizzeRepository.save(quizze);
    }

    @Override
    public List<Quizze> getAllQuizzes() {
        return quizzeRepository.findAll();
    }

    @Override
    public Quizze getQuizzeById(Long id) {
        return quizzeRepository.findById(id).orElse(null);
    }

    @Override
    public Quizze updateQuizze(QuizzeDTO quizzeDTO,Long id) {
        Quizze quizze=quizzeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(ErrorCode.QUIZZE_NOT_FOUND));
        Course course=courseRepository.findById(quizzeDTO.getCourse())
                .orElseThrow(()-> new ResourceNotFoundException(ErrorCode.COURSE_NOT_FOUND));
        quizze.setTitle(quizzeDTO.getTitle());
        quizze.setQuestions(quizzeDTO.getQuestions());
        quizze.setCourse(course);
        return quizzeRepository.save(quizze);
    }

    @Override
    public void deleteQuizze(Long id) {
        Optional<Quizze> quizze=quizzeRepository.findById(id);
        if (!quizze.isPresent()) {
            throw new ResourceNotFoundException(ErrorCode.QUIZZE_NOT_FOUND);
        }
        quizzeRepository.deleteById(id);
    }
}
