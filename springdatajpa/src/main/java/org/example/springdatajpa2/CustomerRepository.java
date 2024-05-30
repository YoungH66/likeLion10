package org.example.springdatajpa2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // 이름으로 조회
//    @Query("select c from Customer c where c.name=:name")
//    List<Customer> findByName(@Param("name") String name);
    List<Customer> findByName(String name);

    // 이메일로 조회
//    @Query("SELECT c from Customer c where c.email = :email")
//    List<Customer> findByEmail(@Param("email") String email);
    List<Customer> findByEmail(String email);

    // 이메일에 특정 문자열을 포함하고 있는 고객 조회
    // 포함하기 위해 %%로 감싸고 = 대신 like 사용
//    @Query("select c from Customer c where c.email like %:email%")
//    List<Customer> findByEmailContain(@Param("email") String email);
    List<Customer> findByEmailContaining(String email);
}
