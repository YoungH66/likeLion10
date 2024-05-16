package org.example.springjdbc03;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionTemplate;

@Repository
@RequiredArgsConstructor
public class UserService {
    private final JdbcTemplate jdbcTemplate;
    private final TransactionTemplate transactionTemplate;

//    // 생성자는 따로 선언하지 않아도 @RequiredArgsConstructor로 만들 수 있다.
//    public UserService(JdbcTemplate jdbcTemplate, TransactionTemplate transactionTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//        this.transactionTemplate = transactionTemplate;
//    }
    public void executeComplexBusinessProcess(String name, String email){
        transactionTemplate.execute(status -> {
            jdbcTemplate.update("INSERT INTO users (name, email) VALUES (?, ?)", name, email);
            if(email.contains("error")){
                status.setRollbackOnly();
                throw new RuntimeException("simulated error to trigger rollback");
            }
            jdbcTemplate.update("UPDATE users SET email = ? WHERE name = ?",  "updated.email@example.com", name);
            return null;
        });
    }
}
