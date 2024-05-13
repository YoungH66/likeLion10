package org.example.iocexm.config;

import org.example.iocexm.controller.UserController;
import org.example.iocexm.dao.UserDao;
import org.example.iocexm.dao.UserDaoImpl;
import org.example.iocexm.service.UserService;
import org.example.iocexm.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = "org.example.iocexm")
public class UserConfig {

    //IOC 컨테이너에 Bean을 등록하는 방법을 생각해보고 동작 될 수 있도록 작성해주세요.
    //1. javaconfig를 이용해서 동작되도록!!

    @Bean
    public UserDao uerDao(){
        return new UserDaoImpl();
    }

    @Bean
    public UserService userService(UserDao userDao){
        UserServiceImpl userSerVice = new UserServiceImpl();
        // userDao 값을 넣어주는 setter 메소드 필요.
        userSerVice.setUserDao(userDao);
        return userSerVice;
////        return new UserServiceImpl(userDao);    // userDao를 인자로 받는 생성자 필요.
    }
//
    @Bean
    public UserController userController(UserService userService){
        return new UserController(userService);
    }

    //2. componentScan 을 이용해서 동작되도록...     코드를 완성해보세요.
    // componentScan을 사용하기 위해
    // 1. 누가 컴포넌트인지 알려준다.
    // 2. componentScan을 추가한다.
}
