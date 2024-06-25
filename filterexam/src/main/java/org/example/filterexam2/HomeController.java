package org.example.filterexam2;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class HomeController {
    private final UserService userService;

//    public HomeController() {
//        log.info("HomeController Constructor run::::::::::::");
//    }

    @GetMapping("/")
    public String home() {
        log.info("home() run:::::");
        return "home";
    }

    @GetMapping("/hi")
    public String hi() {
        User user = UserContext.getUser();
        log.info("hi() run::::: User :: " + user);
        return "hi";
    }

    @GetMapping("/hello")
    public String hello() {
        userService.list();
        log.info("hello() run:::::");
        return "hello";
    }


}
