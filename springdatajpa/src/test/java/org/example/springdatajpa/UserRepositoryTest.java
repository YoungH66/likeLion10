package org.example.springdatajpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

//import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class UserRepositoryTest {
    @Autowired
    private UserRepository repository;

    @Test
    void save() {
        User user = new User("Kim", "kim@test.com");
        repository.save(user);

        System.out.println(user.getId());
    }

    @Test
    void findByName(){
        List<User> users = repository.findByName("Kim");
        assertThat(users.size()).isEqualTo(18);

        List<User> users2 = repository.findByName("kim");
        assertThat(users2.size()).isEqualTo(18);
    }

    @Test
    void updateEmail(){
        repository.updateEmail(6L, "modifiedkim@test.com");
        Optional<User> user = repository.findById(6L);
        assertThat(user.get().getEmail()).isEqualTo("modifiedkim@test.com");
    }

//    @Test
//    void delete(){
//        repository.deleteById(5L);
////        Optional<User> user = repository.findById(5L);
//    }

    @Test
    void deleteByEmail(){
        repository.deleteByEmail("kim@gmail.com");
        Optional<User> user = repository.findById(5L);
        assertThat(user.isPresent()).isFalse();
    }
}