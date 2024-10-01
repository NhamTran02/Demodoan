package com.example.demodoan.controller;

import com.example.demodoan.dto.QuizzeDTO;
import com.example.demodoan.model.Quizze;
import com.example.demodoan.service.QuizzeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quizze")
public class QuizzeController {
    @Autowired
    private QuizzeService quizzeService;

    @PostMapping("")
    public ResponseEntity<Quizze> createQuizze(@RequestBody QuizzeDTO quizzeDTO) {
        return ResponseEntity.ok().body(quizzeService.createQuizze(quizzeDTO));
    }

    @GetMapping("")
    public ResponseEntity<List<Quizze>> getAllQuizzes() {
        return ResponseEntity.ok().body(quizzeService.getAllQuizzes());
    }

    @GetMapping("{id}")
    public ResponseEntity<Quizze> getQuizze(@PathVariable Long id) {
        return ResponseEntity.ok().body(quizzeService.getQuizzeById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<Quizze> updateQuizze(@RequestBody QuizzeDTO quizzeDTO,@PathVariable Long id) {
        return ResponseEntity.ok().body(quizzeService.updateQuizze(quizzeDTO,id));
    }

    @DeleteMapping("")
    public ResponseEntity<String> deleteQuizze(@RequestBody QuizzeDTO quizzeDTO) {
        try {
            quizzeService.deleteQuizze(quizzeDTO.getId());
            return ResponseEntity.ok().body("Quizze deleted");
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Quizze not deleted");
        }
    }
}
