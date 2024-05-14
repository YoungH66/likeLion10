package org.example.jdbc01;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
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
//            List<User> users = jdbcTemplate.query("SELECT id,name,email FROM users", new BeanPropertyRowMapper<>(User.class));
//            for(User user : users){
//                System.out.println(user);
//            }
//            users.forEach(System.out::println);

            // user에서 @NoArgsConstructor, @Setter 를 제외하고 다음과 같이 사용할 수 있다.
            // 위와 같은 방식이다.
            RowMapper<User> rowMapper = (ResultSet rs, int rowNum) -> new User(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("email")
            );

            List<User> users = jdbcTemplate.query("SELECT id,name,email FROM users", rowMapper);

//            users.forEach(System.out::println);

            // 다음은 람다식을 이용한 출력방법이다. toString이 정의되어 있지 않을때 사용해보자
            users.forEach(user -> System.out.println(user));

            for(User user : users) {
                System.out.println(user);
            }

            users.forEach(user -> System.out.println(user.getName() + " - " + user.getEmail()));
        };
    }
}
