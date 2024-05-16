package org.example.springjdbc05;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

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

    // 여기에서만 쓰이고 버려지기 때문에 굳이 외부에 선언하지 않아도 된다.
    private static class UserResultSetExtractor implements ResultSetExtractor<User>{
        // ResultSetExtractor 결과 집합 전체를 단일 객체로 변환하는데 사용된다.
        // 여러 테이블에서 조인된 결과를 받아서 하느이 복합 객체로 매핑
        // 특정 조건에 따라 다양한 타입의 객체를 리스트에 추가할 때 사용할 수 있다.
        // 메소드가 한 번만 호출되서 전체 결과 집합으로 처리
        @Override
        public User extractData(ResultSet rs) throws SQLException{
            User user = new User();
            if(rs.next()) {
                user.setId(rs.getLong("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));

                // 지금 예제에는 user 하나에 대한 값만 채우기 때문에 RowMapper와 크게 차이가 없어보이지만
                // 게시글 이라면, 게시글 하나에.. 댓글 리스트가 필드로 들어올 수 도 있다.
            }
            return user;
        }
    }

}
