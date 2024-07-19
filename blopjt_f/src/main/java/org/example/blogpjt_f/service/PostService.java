package org.example.blogpjt_f.service;

import lombok.extern.slf4j.Slf4j;
import org.example.blogpjt_f.entity.Post;
import org.example.blogpjt_f.entity.User;
import org.example.blogpjt_f.repository.PostRepository;
import org.example.blogpjt_f.repository.UserRepository;
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
    @Autowired
    private UserRepository userRepository;

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public Post getPostById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));
    }

    public List<Post> getPostsByUser(User user) {
        return postRepository.findByAuthorOrderByCreatedAtDesc(user);
    }

    public List<Post> getAllPublishedPosts(String sort) {
        switch(sort) {
            case "latest":
                return postRepository.findByPublishedTrueOrderByCreatedAtDesc();
            case "oldest":
                return postRepository.findByPublishedTrueOrderByCreatedAtAsc();
            default:
                return postRepository.findByPublishedTrue();
        }
    }

    public Post updatePost(Post post) {
        return postRepository.save(post);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }


}