package org.example.blogpjt_f.repository;

import org.example.blogpjt_f.entity.Post;
import org.example.blogpjt_f.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByAuthorOrderByCreatedAtDesc(User author);
    List<Post> findByPublishedOrderByCreatedAtDesc(boolean published);
}