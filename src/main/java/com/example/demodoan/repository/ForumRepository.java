package com.example.demodoan.repository;

import com.example.demodoan.model.Forum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ForumRepository extends JpaRepository<Forum, Long> {
    List<Forum> findByTitleContainingIgnoreCase(String title);
}
