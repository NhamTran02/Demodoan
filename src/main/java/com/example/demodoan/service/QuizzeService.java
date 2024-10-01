package com.example.demodoan.service;

import com.example.demodoan.dto.QuizzeDTO;
import com.example.demodoan.model.Quizze;

import java.util.List;

public interface QuizzeService {
    Quizze createQuizze(QuizzeDTO quizzeDTO);
    List<Quizze> getAllQuizzes();
    Quizze getQuizzeById(Long id);
    Quizze updateQuizze(QuizzeDTO quizzeDTO,Long id);
    void deleteQuizze(Long id);

}
