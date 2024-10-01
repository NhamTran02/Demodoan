package com.example.demodoan.service.impl;

import com.example.demodoan.dto.ForumDTO;
import com.example.demodoan.model.Forum;
import com.example.demodoan.model.User;
import com.example.demodoan.repository.ForumRepository;
import com.example.demodoan.repository.UserRepository;
import com.example.demodoan.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ForumServiceImpl implements ForumService {
    @Autowired
    private ForumRepository forumRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Forum> getAllForum() {
        return forumRepository.findAll();
    }

    @Override
    public Forum createForum(ForumDTO forumDTO) {
        Forum forum = new Forum();

        forum.setTitle(forumDTO.getTitle());
        forum.setContent(forumDTO.getContent());

        User user = userRepository.findById(forumDTO.getUser())
                .orElseThrow(() -> new RuntimeException("Phải đăng nhập tài khoản khoản"));
        forum.setUser(user);

        return forumRepository.save(forum);
    }

    @Override
    public Forum updateForum(Long id, ForumDTO forumDTO) {
        Optional<Forum> optionalForum = forumRepository.findById(id);

        Forum forum = optionalForum.get();

        forum.setTitle(forumDTO.getTitle());
        forum.setContent(forumDTO.getContent());

        User user = userRepository.findById(forumDTO.getUser())
                .orElseThrow(() -> new RuntimeException("Phải đăng nhập tài khoản khoản"));
        forum.setUser(user);

        return forumRepository.save(forum);
    }

    @Override
    public void deleteForum(Long id) {
        forumRepository.deleteById(id);
    }

    @Override
    public List<Forum> findTitleForum(String title) {
        return forumRepository.findByTitleContainingIgnoreCase(title);
    }
}
