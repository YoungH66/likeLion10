package org.example.iocexm;

import org.example.iocexm.controller.UserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class IocexmApplication {

    public static void main(String[] args) {
//        SpringApplication.run(IocexmApplication.class, args);

        ApplicationContext context =  SpringApplication.run(IocexmApplication.class, args);

        UserController userController = context.getBean(UserController.class);
        userController.joinUser();
    }
}
