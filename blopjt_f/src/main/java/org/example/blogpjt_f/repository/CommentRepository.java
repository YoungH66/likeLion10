package org.example.blogpjt_f.repository;

import org.example.blogpjt_f.entity.Comment;
import org.example.blogpjt_f.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPostOrderByCreatedAtDesc(Post post);
    Page<Comment> findByPost(Post post, Pageable pageable);
}