package org.example.blogpjt_f.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.blogpjt_f.entity.Post;
import org.example.blogpjt_f.entity.User;
import org.example.blogpjt_f.service.PostService;
import org.example.blogpjt_f.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
@RequestMapping("/posts")
@Slf4j
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "createPost";
    }

    @PostMapping("/new")
    public String createPost(@ModelAttribute Post post, Principal principal) {
        String username = principal.getName();
        User user = userService.getUserByUsername(username);
        Post savedPost = postService.createPost(post, user.getId());
        return "redirect:/posts/" + savedPost.getId();
    }

    @GetMapping
    public String listPosts(Model model) {
        model.addAttribute("posts", postService.getAllPublishedPosts());
        return "listPosts";
    }

    @GetMapping("/{id}")
    public String viewPost(@PathVariable Long id, Model model) {
        model.addAttribute("post", postService.getPostById(id));
        return "viewPost";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("post", postService.getPostById(id));
        return "editPost";
    }

    @PostMapping("/{id}/edit")
    public String updatePost(@PathVariable Long id, @ModelAttribute Post post) {
        Post existingPost = postService.getPostById(id);
        existingPost.setTitle(post.getTitle());
        existingPost.setContent(post.getContent());
        existingPost.setPublished(post.isPublished());
        postService.updatePost(existingPost);
        return "redirect:/posts/" + id;
    }

    @PostMapping("/{id}/delete")
    public String deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return "redirect:/posts";
    }
}