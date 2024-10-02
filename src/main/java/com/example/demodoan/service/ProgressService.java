package com.example.demodoan.service;

import com.example.demodoan.dto.ProgressDTO;
import com.example.demodoan.model.Progress;

import java.util.List;

public interface ProgressService {
    List<Progress> getAllProgress();
    Progress createProgress(ProgressDTO progressDTO);
    Progress updateProgress(Long id, ProgressDTO progressDTO);
    void deleteProgress(Long id);
}
