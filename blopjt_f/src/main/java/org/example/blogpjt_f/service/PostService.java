package org.example.blogpjt_f.service;

import lombok.extern.slf4j.Slf4j;
import org.example.blogpjt_f.entity.Post;
import org.example.blogpjt_f.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@Slf4j
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Post createPost(Post post) {
        log.info("Creating post in service: {}", post);
        post.setCreatedAt(LocalDateTime.now());
        Post savedPost = postRepository.save(post);
        log.info("Post saved in service: {}", savedPost);
        return savedPost;
    }

    public Post getPostById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));
    }

    public List<Post> getAllPublishedPosts() {
        return postRepository.findByPublishedOrderByCreatedAtDesc(true);
    }

    public Post updatePost(Post post) {
        return postRepository.save(post);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}