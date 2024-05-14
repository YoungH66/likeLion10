package org.example.jdbc03.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserDaoImpl implements UserDao {
    // final이 붙은것에 한해서 @RequiredArgsConstructor 을 붙이면 생성자를 자동으로 추가해준다.
    private final JdbcTemplate jdbcTemplate;

    @Override
    public void insertUser(User user) {
        try {
            jdbcTemplate.update("INSERT INTO users(name, email) VALUES (?,?)"
                    , user.getName(), user.getEmail());
        }catch (DataAccessException e) {
            throw new DataAccessException("사용자 입력 오류" + user.getName(), e){};
        }

    }

    @Override
    public List<User> findAllUsers() {
        try {
            List<User> users = jdbcTemplate.query("SELECT * FROM users", new BeanPropertyRowMapper<User>(User.class));
            return users;
        }catch (DataAccessException e) {
            throw new DataAccessException("사용자 검색 오류", e) {};
        }
    }

    @Override
    public void updateUserEmail(String name, String email) {
        int updated = jdbcTemplate.update("UPDATE users SET email = ? WHERE name = ?", email, name);
        if(updated != 1) {
            throw new UserNotFoundException("사용자 검색 실패 :: " + name);
        }
    }

    @Override
    public void deleteUser(String name) {
        int deleted = jdbcTemplate.update("DELETE FROM users WHERE name = ?", name);
        if(deleted != 1) {
            throw new UserNotFoundException("사용자 검색 실패 :: " + name);
        }
    }
}
