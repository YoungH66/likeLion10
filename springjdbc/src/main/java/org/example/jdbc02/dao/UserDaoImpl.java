package org.example.jdbc02.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserDaoImpl implements UserDao{

    // jdbcTemplete 객체를 이용해서 구현하는것을 목표로 한다.

//    // 필드 기반
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    // 생성자 기반
//    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    //설정자 기반
//    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }

    // final이 붙은것에 한해서 @RequiredArgsConstructor 을 붙이면 생성자를 자동으로 추가해준다.
    private final JdbcTemplate jdbcTemplate;

    @Override
    public void insertUser(User user) {
        jdbcTemplate.update("INSERT INTO users(name, email) VALUES (?,?)"
                , user.getName(), user.getEmail());
    }

    @Override
    public List<User> findAllUsers() {
        List<User> users = jdbcTemplate.query("SELECT * FROM users", new BeanPropertyRowMapper<User>(User.class));
        return users;
    }

    @Override
    public void updateUserEmail(String name, String email) {
        jdbcTemplate.update("UPDATE users SET email = ? WHERE name = ?", email, name);
    }

    @Override
    public void deleteUser(String name) {
        jdbcTemplate.update("DELETE FROM users WHERE name = ?", name);
    }
}
