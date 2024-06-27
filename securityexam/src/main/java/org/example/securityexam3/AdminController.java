package org.example.securityexam3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/abc") // Admin 만 접근 허용하도록
    public String abc() {
        return "abc";
    }

    @GetMapping("/def") // Admin, superuser 접근 허용하도록
    public String def() {
        return "def";
    }

    @GetMapping("/list") // Admin, superuser 접근 허용하도록
    public String list() {
        return "list";
    }

    @GetMapping("/add") // Admin, superuser 접근 허용하도록
    public String add() {
        return "add";
    }
}
