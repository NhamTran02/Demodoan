package com.example.demodoan.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tbl_quizzes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Quizze extends Base{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(columnDefinition = "TEXT")
    private String questions;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}
