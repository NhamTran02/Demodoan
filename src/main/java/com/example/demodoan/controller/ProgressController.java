package com.example.demodoan.controller;

import com.example.demodoan.dto.ProgressDTO;
import com.example.demodoan.model.Progress;
import com.example.demodoan.service.impl.ProgressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/progress")
public class ProgressController {
    @Autowired
    private ProgressServiceImpl progressServiceImpl;

    @PostMapping
    Progress createProgress(@RequestBody ProgressDTO progressDTO){
        return progressServiceImpl.createProgress(progressDTO);
    }

    @GetMapping
    List<Progress> getAllProgress(){
        return progressServiceImpl.getAllProgress();
    }

    @PutMapping("/{id}")
    Progress updateProgress (@PathVariable Long id, @RequestBody ProgressDTO progressDTO){
        return progressServiceImpl.updateProgress(id, progressDTO);
    }

    @DeleteMapping("/{id}")
    String deleteProgress(@PathVariable Long id){
        progressServiceImpl.deleteProgress(id);
        return "Xóa thành công";
    }
}
