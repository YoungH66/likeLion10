package org.example.springjdbc02;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Springjdbc02Application {
    public static void main(String[] args) {
        SpringApplication.run(Springjdbc02Application.class, args);
    }

    @Bean
    public CommandLineRunner demo01(UserDao userDao) {
        return args -> {
            try {
                // 예외상황을 가정 했으니 확인
//                userDao.createAndUpdateUser("YH", "yh11@exam.com", "yh11@exam.com");
                // 예외 예제
                userDao.createAndUpdateUser("YH02", "yh11@exam.com", "error@exam.com");
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        };
    }
}
