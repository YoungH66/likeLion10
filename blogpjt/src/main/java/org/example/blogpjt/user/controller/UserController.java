package org.example.blogpjt.user.controller;

import org.example.blogpjt.user.domain.User;
import org.example.blogpjt.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showMainPage() {
        return "index";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";
    }

    @GetMapping("/loginform")
    public String showLoginForm() {
        return "user/loginform";
    }

    @GetMapping("/registerform")
    public String showRegisterForm() {
        return "user/registerform";
    }

    @PostMapping("/userreg")
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "user/registerform";
        }
        try {
            userService.registerUser(user);
            System.out.println("User registered successfully: " + user.getUsername());
            return "redirect:/loginform";
        } catch (RuntimeException e) {
            System.err.println("Error registering user: " + e.getMessage());
            model.addAttribute("error", e.getMessage());
            return "user/registerform";
        }
    }
}