package org.example.filterexam4.repository;

import org.example.filterexam4.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // id - 의미없는 값.. 이번엔 username으로 찾아오는 메소드가 필요
    User findByUsername(String username);
}
