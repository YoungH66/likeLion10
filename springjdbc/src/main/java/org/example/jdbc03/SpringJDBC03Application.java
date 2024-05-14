package org.example.jdbc03;

import org.example.jdbc03.SpringJDBC03Application;
import org.example.jdbc03.dao.User;
import org.example.jdbc03.dao.UserDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringJDBC03Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringJDBC03Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserDao userDao){
        return args -> {
            // insert test
            // userDao.insertUser(new User(null, "John", "john@gmail.com"));

            // updateEmail test
            userDao.updateUserEmail("Kim", "KimNew123@example.com");

            // deleteUser test
            userDao.deleteUser("John");

            // findAllUsers test
            List<User> userList = userDao.findAllUsers();
            userList.forEach(user -> System.out.println(user.getId() + " - " + user.getName() + " - " + user.getEmail()));
        };
    }
}
