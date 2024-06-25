package org.example.filterexam4.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.example.filterexam3.User;
import org.example.filterexam4.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/loginform")
    public String loginForm() {
        return "loginform";
    }

    @PostMapping("/login")
    public String loginform(@ModelAttribute("user") User user, HttpServletResponse response) {

        //사용자가 보낸 username과 패스워드가 서버가 원하는 정보랑 일치하는지 확인하고
        //사용자 정보를 유지하게 하면 된다.
        if(user.getUsername().equals("carami") && user.getPassword().equals("1234")){
            //실제 서비스에서는 아이디 암호를 검사해서 진행하겠지만...   여기서는 간단하게..
            Cookie cookie = new Cookie("auth","carami");
            cookie.setPath("/");

            //이렇게 생성된 쿠키는 클라이언에게 보내져야한다.
            response.addCookie(cookie);
        }

        return "redirect:/welcome";
    }
}
