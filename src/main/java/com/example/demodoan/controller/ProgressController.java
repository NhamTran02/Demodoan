package com.example.demodoan.controller;

import com.example.demodoan.dto.request.ProgressDTO;
import com.example.demodoan.model.Progress;
import com.example.demodoan.service.ProgressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/progress")
public class ProgressController {
    @Autowired
    private ProgressService progressService;

    @PostMapping
    Progress createProgress(@Valid @RequestBody ProgressDTO progressDTO){
        return progressService.createProgress(progressDTO);
    }

    @GetMapping
    List<Progress> getAllProgress(){
        return progressService.getAllProgress();
    }

    @PutMapping("/{id}")
    Progress updateProgress (@PathVariable Long id,@Valid @RequestBody ProgressDTO progressDTO){
        return progressService.updateProgress(id, progressDTO);
    }

    @DeleteMapping("/{id}")
    String deleteProgress(@PathVariable Long id){
        progressService.deleteProgress(id);
        return "Xóa thành công";
    }
}
