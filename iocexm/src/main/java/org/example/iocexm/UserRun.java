package org.example.iocexm;

import org.example.iocexm.config.UserConfig;
import org.example.iocexm.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserRun {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(UserConfig.class);

        UserController userController = context.getBean(UserController.class);
        userController.joinUser();

        //
    }
}
