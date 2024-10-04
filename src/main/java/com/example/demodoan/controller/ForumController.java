package com.example.demodoan.controller;

import com.example.demodoan.dto.request.ForumDTO;
import com.example.demodoan.dto.response.ForumListResponse;
import com.example.demodoan.model.Forum;
import com.example.demodoan.service.ForumService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/forum")
public class ForumController {
    @Autowired
    private ForumService forumService;

    @PostMapping
    Forum createForum(@Valid  @RequestBody ForumDTO forumDTO){
        return forumService.createForum(forumDTO);
    }

    @GetMapping
    List<Forum> getAllForum(){
        return forumService.getAllForum();
    }

    @PutMapping("/{id}")
    Forum updateForum (@PathVariable Long id,@Valid @RequestBody ForumDTO forumDTO){
        return forumService.updateForum(id, forumDTO);
    }

    @DeleteMapping("/{id}")
    String deleteForum(@PathVariable Long id){
        forumService.deleteForum(id);
        return "Xóa thành công";
    }

    @GetMapping("/{title}")
    List<Forum> findTitleForum (@PathVariable String title){
        return forumService.findTitleForum(title);
    }

    @GetMapping("/page")
    public ResponseEntity<?> getAllForumPage(@RequestParam int page,@RequestParam int limit){
        PageRequest pageRequest= PageRequest.of(page,limit, Sort.by("createAt").descending());
//        PageRequest pageRequest= PageRequest.of(page,limit);
        Page<ForumDTO> forumPage=forumService.getAllForumPage(pageRequest);
        int totalPages=forumPage.getTotalPages();
        List<ForumDTO> forums=forumPage.getContent();
        return ResponseEntity.ok().body(ForumListResponse.builder()
                        .forums(forums)
                        .totalPages(totalPages)
                        .build());
    }
}
