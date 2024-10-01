package com.example.demodoan.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_quizzes")
@Getter
@Setter
@Builder
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
