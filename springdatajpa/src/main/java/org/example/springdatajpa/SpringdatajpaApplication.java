package org.example.springdatajpa;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@Slf4j
public class SpringdatajpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringdatajpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(UserRepository repository) {
        return args -> {
//          // create
//          User user = new User("Kim","kim@gmail.com");
//          repository.save(user);
//          log.info("User add : " + user.getName());
//          log.info("User id : " + user.getId());
//          log.info("User email : " + user.getEmail());
//
//          // delete
//          repository.delete(user);
//          log.info("deleted user : " + user);

//            List<User> users = repository.findByName("Kim");
//            users.forEach(user -> log.info(user.getName() + "::" + user.getEmail()));


        };
    }
}
