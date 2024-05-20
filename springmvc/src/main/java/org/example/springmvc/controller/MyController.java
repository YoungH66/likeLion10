package org.example.springmvc.controller;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

@Controller
//@RestController
public class MyController {
    @GetMapping("/home")
    public String name(){
        return "home";
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }

    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }

    @ResponseBody
    @GetMapping("rest")
    public String rest(){
        return "restbody test!!";
    }

//    @GetMapping("greeting")
//    public String greet(
//            @RequestParam(name = "abc", required = false, defaultValue = "kang") String name,
//            @RequestParam(name = "age", required = false, defaultValue = "10") int age){
//        // http://localhost/greeting?name=yh
//        // ?name=yh&age=20 쿼리문자열
//        System.out.println(name);
//        System.out.println(age);
//
////        System.out.println("request ::: " + request.getParameter("name"));
////        System.out.println("request ::: " + request.getParameter("age"));
//
//        return "greeting";
//    }

//    @Bean
//    public InternalResourceViewResolver internalResourceViewResolver(){
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix("/WEB-INF/views/");
//        resolver.setSuffix(".jsp");
//        resolver.setOrder(1);
//        return resolver;
//    }
//
//    @Bean
//    public ThymeleafViewResolver thymeleafViewResolver(SpringTemplateEngine templateEngine){
//        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
//        resolver.setTemplateEngine(templateEngine);
//        resolver.setOrder(2);
//        return resolver;
//    }
}
