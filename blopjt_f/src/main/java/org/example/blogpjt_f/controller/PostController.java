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
import java.util.List;

@Controller
@RequestMapping("/posts")
@Slf4j
public class PostController {
    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @GetMapping
    public String listPosts(@RequestParam(defaultValue = "latest") String sort, Model model) {
        List<Post> posts = postService.getAllPublishedPosts(sort);
        model.addAttribute("posts", posts);
        model.addAttribute("currentSort", sort);
        return "listPosts";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "createPost";
    }

    @PostMapping("/new")
    public String createPost(@ModelAttribute Post post, @RequestParam(defaultValue = "true") boolean publish, Principal principal) {
        String username = principal.getName();
        User user = userService.getUserByUsername(username);
        post.setPublished(publish);
        post.setAuthor(user);
        Post savedPost = postService.createPost(post);
        return "redirect:/posts/" + savedPost.getId();
    }

    @GetMapping("/my-posts")
    public String listMyPosts(Principal principal, Model model) {
        User currentUser = userService.getUserByUsername(principal.getName());
        List<Post> posts = postService.getPostsByUser(currentUser);
        model.addAttribute("posts", posts);
        return "myPost";
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