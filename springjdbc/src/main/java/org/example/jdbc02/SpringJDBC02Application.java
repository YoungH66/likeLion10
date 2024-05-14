package org.example.jdbc02;

import org.example.jdbc02.dao.User;
import org.example.jdbc02.dao.UserDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringJDBC02Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringJDBC02Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserDao userDao){
        return args -> {
//            userDao.insertUser(new User(null, "John", "john@gmail.com"));
            List<User> userList = userDao.findAllUsers();
            userList.forEach(user -> System.out.println(user.getId() + " - " + user.getUsername() + " - " + user.getEmail()));
        };
    }
}
