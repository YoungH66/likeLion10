package org.example.iocexm.dao;

import org.example.iocexm.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserCaramiDaoImpl  implements UserDao{
    @Override
    public User getUser(String email) {
        return null;
    }

    @Override
    public List<User> getUsers() {
        return List.of();
    }

    @Override
    public void addUser(User user) {
        System.out.println(user + "의 정보를 CaramiDAO를 통해 잘 저장했습니다.");
    }
}
