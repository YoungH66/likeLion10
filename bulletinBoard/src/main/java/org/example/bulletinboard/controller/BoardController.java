package org.example.bulletinboard.controller;

import lombok.RequiredArgsConstructor;
import org.example.bulletinboard.domain.Board;
import org.example.bulletinboard.service.BoardService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String view(@RequestParam("id") Long id, @RequestParam("page") int page, Model model) {
        Board board = boardService.findPostById(id);
        model.addAttribute("board", board);
        model.addAttribute("currentPage", page);
        return "view";
    }
}
