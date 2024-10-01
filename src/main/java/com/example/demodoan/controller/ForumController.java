package com.example.demodoan.controller;

import com.example.demodoan.dto.ForumDTO;
import com.example.demodoan.model.Forum;
import com.example.demodoan.service.impl.ForumServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/forum")
public class ForumController {
    @Autowired
    private ForumServiceImpl forumServiceImpl;

    @PostMapping
    Forum createForum(@Valid  @RequestBody ForumDTO forumDTO){
        return forumServiceImpl.createForum(forumDTO);
    }

    @GetMapping
    List<Forum> getAllForum(){
        return forumServiceImpl.getAllForum();
    }

    @PutMapping("/{id}")
    Forum updateForum (@PathVariable Long id,@Valid @RequestBody ForumDTO forumDTO){
        return forumServiceImpl.updateForum(id, forumDTO);
    }

    @DeleteMapping("/{id}")
    String deleteForum(@PathVariable Long id){
        forumServiceImpl.deleteForum(id);
        return "Xóa thành công";
    }

    @GetMapping("/{title}")
    List<Forum> findTitleForum (@PathVariable String title){
        return forumServiceImpl.findTitleForum(title);
    }
}
