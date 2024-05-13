package org.example.jdbc01;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SpringBootApplication
public class SpringJDBCApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringJDBCApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(JdbcTemplate jdbcTemplate) {
        return args -> {
          // user 입력
            String sql = "INSERT INTO users(name, email) VALUES(?,?)";
            jdbcTemplate.update(sql, "Kim", "Kim1234@example.com");

            // Read
            // RowMapper 를 이용해야 하는 이유는 결과값을 담을때, 테이블의 컬럼과, User 클래스의 필드를 매칭해주기 위함

            List<User> users = jdbcTemplate.query("SELECT id,name,email FROM users", new BeanPropertyRowMapper<>(User.class));
//            for(User user : users){
//                System.out.println(user);
//            }
            users.forEach(System.out::println);
        };
    }
}
