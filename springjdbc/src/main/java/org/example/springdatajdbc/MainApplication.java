package org.example.springdatajdbc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner demo(UserRepository userRepository) {
//        return args -> {
//            // CrudRepository.save는 엔티티를 받음
////            userRepository.save(new User("gode", "gode@exam.com"));
////
////            User user = userRepository.findById(9L).get();
////            System.out.println(user.getName());
////
////            System.out.println(userRepository.findByName("enonu"));
//
//            PageRequest pageRequest = PageRequest.of(0, 5);
//            Page<User> allUser = userRepository.findAllUsersWithPagination(pageRequest);
//
//            allUser.forEach(user -> System.out.println(user.getName() + " - " + user.getEmail()));
//        };
//    }

    @Bean
    public CommandLineRunner batchUpdateDemo(JdbcTemplate jdbcTemplate) {
        return args -> {
            List<User> users = Arrays.asList(
                    new User(null, "Alice", "alice@example.com"),
                    new User(null, "Bob", "bob@example.com"),
                    new User(null, "Charlie", "charlie@example.com"),
                    new User(null, "David", "david@example.com")
            );
            // Prepare SQL query for batch update
            String sql = "INSERT INTO users (name, email) VALUES (?, ?)";

            // Execute batch update
            int[] updateCounts = jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    User user = users.get(i);
                    ps.setString(1, user.getName());
                    ps.setString(2, user.getEmail());
                }

                public int getBatchSize() {
                    return users.size();
                }
            });

            System.out.println("Batch update completed. Number of rows affected: " + Arrays.toString(updateCounts));
        };
    }
};

