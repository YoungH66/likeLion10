package org.example.securityexam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/info")
    public String info() {
        return "info";
    }

    @GetMapping("/hi")
    public String hi() {
        return "hi";
    }

    @GetMapping("heolo")
    public String hello() {
        return "hello";
    }
}
