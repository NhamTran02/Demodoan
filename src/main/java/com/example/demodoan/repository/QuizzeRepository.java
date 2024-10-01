package com.example.demodoan.repository;

import com.example.demodoan.model.Quizze;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizzeRepository extends JpaRepository<Quizze, Long> {
}
