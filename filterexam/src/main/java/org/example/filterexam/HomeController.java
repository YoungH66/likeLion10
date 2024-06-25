package org.example.filterexam;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HomeController {

    public HomeController() {
        log.info("HomeController Constructor run::::::::::::");
    }

    @GetMapping("/")
    public String home() {
        log.info("home() run:::::");
        return "home";
    }

    @GetMapping("/hi")
    public String hi() {
        log.info("hi() run:::::");
        return "hi";
    }

    @GetMapping("/hello")
    public String hello() {
        log.info("hello() run:::::");
        return "hello";
    }


}
