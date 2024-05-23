package org.example.friendexam.controller;

import lombok.RequiredArgsConstructor;
import org.example.friendexam.domain.Friend;
import org.example.friendexam.service.FriendService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("/friends")
public class FriendController {
    private final FriendService friendService;

    @GetMapping
    public String friends(Model model){
        Iterable<Friend> friends =  friendService.findAllFriends();
        model.addAttribute("friends", friends);
        return "friends/list";
    }

    // 친구 등록 - url 몇개? -- addForm add   -- 메소드별로 따로 일
    // friends/add  Get Post
    @GetMapping("/add")
    public String addForm(Model model){
        model.addAttribute("friend", new Friend());
        return "friends/form";
    }

    @PostMapping("/add")
    public String addFriend(@ModelAttribute Friend friend,
                            RedirectAttributes redirectAttributes){
        friendService.saveFriend(friend);
        redirectAttributes.addFlashAttribute("message", "add successfully");
        return "redirect:/friends";
    }

    // 상세 페이지
    // localhost/friends/1
    @GetMapping("/{id}")
    public String detailFriend(@PathVariable Long id, Model model){
        Friend friend = friendService.findFriendById(id);
        model.addAttribute("friend", friend);
        return "friends/detail";
    }

    
}
