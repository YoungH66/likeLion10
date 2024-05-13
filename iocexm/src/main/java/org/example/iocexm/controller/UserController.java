package org.example.iocexm.controller;

import org.example.iocexm.domain.User;
import org.example.iocexm.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
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
