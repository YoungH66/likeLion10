package org.example.springjdbc05;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SpringJdbc05Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringJdbc05Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(JdbcTemplate jdbcTemplate) {
        return args -> {
            String sql = "SELECT id, name, email FROM users";
            User user = jdbcTemplate.query(sql, new UserResultSetExtractor());
            System.out.println(user);
        };
    }
}
