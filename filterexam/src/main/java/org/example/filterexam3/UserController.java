package org.example.filterexam3;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class UserController {

    @GetMapping("/loginform")
    public String loginForm() {
        return "loginform";
    }

    // loginform.html에 action이 /login으로 되어 있다.
    @PostMapping("/login")
    public String loginConfirm(@ModelAttribute("user") User user, HttpServletResponse response) {

        // 사용자가 보낸 username과 password가 서버가 원하는 정보와 일치하는지 확인
        // 사용자 정보를 유지하도록..
        log.info("username :: " + user.getUsername());
        log.info("password :: " + user.getPassword());
        if(user.getUsername().equals("yh") && user.getPassword().equals("1234")) {
            // 실제 서비스에서는 아이디 암호를 검사해서 진행될것... 이번에는 간단하게 예시로 확인한다.
            Cookie cookie = new Cookie("auth", "yh");
            cookie.setPath("/");    // 유효 범위를 root로 지정

            // 생성된 쿠키는 클라이언트에게 보내져야 한다.
            response.addCookie(cookie);
            return "redirect:/welcome";
        }
        return "redirect:/loginform";
    }

    @GetMapping("/welcome")
    public String welcome() {
        User user = UserContext.getUser();
        if(user != null) {
            return "welcome";
        } else
            return "redirect:/loginform";
    }

    @GetMapping("/info")
    // ResponseBody를 사용하면 뷰 없이 리턴값을 볼 수 있다. 이 경우 info
//    @ResponseBody
    public String info(HttpServletRequest request) {
        // 아무나 보여줄 수 있는 페이지가 아님
        // 로그인에 성공한 사용자만 접근 가능
        // 쿠키정보를 통해서 판별할 수 있음
//        String auth = null;
//        Cookie[] cookies = request.getCookies();
//        if(cookies != null) {
//            for(Cookie cookie : cookies) {
//                if(cookie.getName().equals("auth")) {
//                    auth = cookie.getValue();
//                    break;
//                }
//            }
//        }
//
//        if(auth != null)    // 인증된 사용자인지 검사
//            return "info";
//        else return "redirect:/loginform";

        User user = UserContext.getUser();
        if(user != null)
            return "info";
        else
            return "redirect:/loginform";
    }

}
