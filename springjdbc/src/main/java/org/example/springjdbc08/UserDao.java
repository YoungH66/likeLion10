package org.example.springjdbc08;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class UserDao {
    private final JdbcTemplate jdbcTemplate;

    // 입력이되면, 자동으로 생성된 pk값을 리턴
    // SimpleJdbcInsert
    private SimpleJdbcInsert simpleJdbcInsert;
    // 생성된 직후에 동작
    @PostConstruct
    public void init() {
        simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("users").usingGeneratedKeyColumns("id");
    }

    public User insertUser(User user) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", user.getName());
        params.put("email", user.getEmail());

        Number pk = simpleJdbcInsert.executeAndReturnKey(params);
        user.setId(pk.longValue());
        return user;
    }

}
