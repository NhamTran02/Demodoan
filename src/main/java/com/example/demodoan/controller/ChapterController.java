package com.example.demodoan.controller;

import com.example.demodoan.dto.request.ChapterDTO;
import com.example.demodoan.model.Chapter;
import com.example.demodoan.service.ChapterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/chapter")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;

    @PostMapping
    Chapter createChapter(@Valid @RequestBody ChapterDTO chapterDTO){
        return chapterService.createChapter(chapterDTO);
    }

    @GetMapping
    List<Chapter> getAllChapter(){
        return chapterService.getAllChapters();
    }

    @PutMapping("/{id}")
    Chapter updateChapter (@PathVariable Long id,@Valid @RequestBody ChapterDTO chapterDTO){
        return chapterService.updateChapter(id, chapterDTO);
    }

    @DeleteMapping("/{id}")
    String deleteChapter(@PathVariable Long id){
        chapterService.deleteChapter(id);
        return "Xóa thành công";
    }

    @GetMapping("/{name}")
    List<Chapter> findNameChapter (@PathVariable String name){
        return chapterService.findNameChapter(name);
    }
}
