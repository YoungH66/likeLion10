package org.example.springmvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoutinController {
    @GetMapping("/start")
    public String startProcess(Model model) {
        model.addAttribute("forwardTest", "yh");
        System.out.println("startProcess");
        return "forward:/forward";
    }

    @GetMapping("/forward")
    public String forward(Model model, HttpServletRequest request) {
        System.out.println("forwardTest:::" + model.getAttribute("forwardTest"));
        System.out.println(request.getAttribute("forwardTest"));
        System.out.println("forward");
        return "forwardPage";
    }

    @GetMapping("/redirect")
    public String redirect(Model model) {
        System.out.println("redirectProcess");
        model.addAttribute("redirectTest", "yh");
        return "redirect:/finalDestination";
    }

    @GetMapping("/finalDestination")
    public String finalDestination(Model model) {
        System.out.println("redirectTest:::" + model.getAttribute("redirectTest"));
        System.out.println("finalDestinaiton");
        return "redirectPage";
    }
}
