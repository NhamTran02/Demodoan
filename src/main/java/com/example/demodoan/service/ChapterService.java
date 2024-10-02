package com.example.demodoan.service;

import com.example.demodoan.dto.ChapterDTO;
import com.example.demodoan.model.Chapter;

import java.util.List;


public interface ChapterService {
    List<Chapter> getAllChapters();
    Chapter createChapter(ChapterDTO chapterDTO);
    Chapter updateChapter(Long id, ChapterDTO chapterDTO);
    void deleteChapter(Long id);
    List<Chapter> findNameChapter(String name);
}
