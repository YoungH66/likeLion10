package org.example.bulletinboard.controller;

import lombok.RequiredArgsConstructor;
import lombok.experimental.PackagePrivate;
import org.example.bulletinboard.domain.Board;
import org.example.bulletinboard.service.BoardService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/list")
    public String postList(Model model, @RequestParam(defaultValue = "1")int page,
                           @RequestParam(defaultValue = "5")int size) {
        Pageable pageable = PageRequest.of(page - 1, size);

        Page<Board> list = boardService.findAllPosts(pageable);
        model.addAttribute("lists", list);
        model.addAttribute("currentPage", page);
        return "/list";
    }

    @GetMapping("/view")
    public String view(@RequestParam("id") Long id,
                       @RequestParam("page") int page, Model model) {
        Board board = boardService.findPostById(id);
        model.addAttribute("board", board);
        model.addAttribute("currentPage", page);
        return "/view";
    }

    @GetMapping("/write")
    public String writeForm(Model model) {
        model.addAttribute("board", new Board());
        return "WriteForm";
    }

    @PostMapping("/write")
    public String write(@ModelAttribute Board board,
                        RedirectAttributes redirectAttributes) {
        board.setCreatedAt(LocalDate.now());
        boardService.editPost(board);
        redirectAttributes.addFlashAttribute("message", "Post created successfully!");
        return "redirect:/list";
    }

    @GetMapping("/deleteform")
    public String deleteForm(@RequestParam("id") Long id,
                             @RequestParam("page") int page, Model model) {
        Board board = boardService.findPostById(id);
        model.addAttribute("board", board);
        model.addAttribute("currentPage", page);
        return "DeleteForm";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") Long id,
                         @RequestParam("password") String password,
                         @RequestParam("page") int page,
                         RedirectAttributes redirectAttributes) {
        boolean isDeleted = boardService.deletePost(id, password);
        if (isDeleted) {
            redirectAttributes.addFlashAttribute("message", "Post deleted successfully!");
        } else {
            redirectAttributes.addFlashAttribute("error", "Invalid password. Post not deleted.");
        }
        return "redirect:/list?page=" + page;
    }

    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable("id") Long id, Model model) {
        Board board = boardService.findPostById(id);
        model.addAttribute("board", board);
        return "UpdateForm";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Board board,
                         RedirectAttributes redirectAttributes) {
        boardService.editPost(board);
        redirectAttributes.addFlashAttribute("message", "Post updated successfully!");
        return "redirect:/list";
    }
}
