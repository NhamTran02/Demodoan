package com.example.demodoan.service;

import com.example.demodoan.dto.ForumDTO;
import com.example.demodoan.model.Forum;

import java.util.List;

public interface ForumService {
    List<Forum> getAllForum();
    Forum createForum(ForumDTO forumDTO);
    Forum updateForum(Long id, ForumDTO forumDTO);
    void deleteForum(Long id);
    List<Forum> findTitleForum(String title);
}
