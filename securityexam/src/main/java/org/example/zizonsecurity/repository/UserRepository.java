package org.example.zizonsecurity.repository;

import org.example.zizonsecurity.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
