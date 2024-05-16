package org.example.springjdbc04;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper {
    // 목적 : RowMapper는 결과 집합(ResultSet)의 각 행을 개별 객체로 매핑하는 데 사용된다.
    // 주로 단일 유형의 객체 목록을 반환할 때 사용된다. 결과 집합의 각 행마다 한 번씩 메소드가 호출됨
    // 용도 : 보통 단일 타입의 객체 목록을 만들때 사용
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        String name = rs.getString("name");
        String email = rs.getString("email");
        return new User(id, name, email);
    }
}
