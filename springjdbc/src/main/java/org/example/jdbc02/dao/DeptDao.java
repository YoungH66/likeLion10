package org.example.jdbc02.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class DeptDao {
    private final JdbcTemplate jdbcTemplate;
    public List<Dept> getDepts() {
        // 람다식으로 따로 클래스를 생성하지 않고 사용 가능
        RowMapper<Dept> rowMapper = (ResultSet rs, int rowNum) -> {
            Dept dept = new Dept();
            dept.setId(rs.getInt("deptno"));
            dept.setDeptName(rs.getString("dname"));
            dept.setLocation(rs.getString("loc"));
            return dept;
        };

        return jdbcTemplate.query("SELECT * FROM dept", new DeptRowMapper());
    }
}
