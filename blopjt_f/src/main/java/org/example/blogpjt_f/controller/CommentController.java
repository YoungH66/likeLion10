package org.example.blogpjt_f.controller;

import org.example.blogpjt_f.entity.Comment;
import org.example.blogpjt_f.entity.Post;
import org.example.blogpjt_f.entity.User;
import org.example.blogpjt_f.service.CommentService;
import org.example.blogpjt_f.service.PostService;
import org.example.blogpjt_f.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @PostMapping("/posts/{postId}/comments")
    public String addComment(@PathVariable Long postId,
                             @RequestParam String content,
                             @AuthenticationPrincipal UserDetails userDetails) {
        Post post = postService.getPostById(postId);
        User user = userService.getUserByUsername(userDetails.getUsername());

        if (post.isPublished()) {
            commentService.createComment(content, post, user);
        }

        return "redirect:/posts/" + postId;
    }

    @PostMapping("/comments/{commentId}/delete")
    public String deleteComment(@PathVariable Long commentId,
                                @AuthenticationPrincipal UserDetails userDetails) {
        // 여기에 댓글 삭제 권한 확인 로직 추가 필요
        commentService.deleteComment(commentId);
        return "redirect:/posts"; // 적절한 리다이렉트 경로로 수정 필요
    }

    @PostMapping("/comments/{commentId}/edit")
    public String editComment(@PathVariable Long commentId,
                              @RequestParam String content,
                              @AuthenticationPrincipal UserDetails userDetails) {
        Comment comment = commentService.getCommentById(commentId);
        if (comment.getAuthor().getUsername().equals(userDetails.getUsername())) {
            commentService.updateComment(commentId, content);
        }
        return "redirect:/posts/" + comment.getPost().getId();
    }

    @GetMapping("/comments/{commentId}")
    @ResponseBody
    public Comment getComment(@PathVariable Long commentId) {
        return commentService.getCommentById(commentId);
    }
}