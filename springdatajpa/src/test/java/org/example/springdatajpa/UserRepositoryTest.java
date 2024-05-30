package org.example.springdatajpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;

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
//        assertThat(users.size().isEqualTo(1));
    }
}