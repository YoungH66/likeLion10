package org.example.springdatajdbc;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
// crudrepository는 프라이머리와 그 타입을 받음
public interface UserRepository extends CrudRepository<User, Long>, CustomUserRepository {
    User findByName(String name);
}
