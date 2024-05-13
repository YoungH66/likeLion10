package org.example.iocexm.controller;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.annotation.Resource;
import org.example.iocexm.domain.User;
import org.example.iocexm.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

//@Controller
public class UserController {
    @Resource
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void init() {
        // 해당 빈이 생성된 직후 호출
        System.out.println("postConstruct 실행");
    }

    @PreDestroy
    public void destroy() {
        // 빈이 소멸되기 직전에 호출
        System.out.println("preDestroy 실행");
    }

    public void joinUser(){
        //실제 동작할 때는 사용자로 부터 정보를 받아온다.
        User user = new User();
        user.setName("kang");
        user.setEmail("carami@gmail.com");
        user.setPassword("1234");

        userService.joinUser(user);
    }
}
