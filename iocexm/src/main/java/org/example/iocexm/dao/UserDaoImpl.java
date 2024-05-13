package org.example.iocexm.dao;

import org.example.iocexm.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDaoImpl implements UserDao{
    @Override
    public User getUser(String email) {
        return null;
    }

    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public void addUser(User user) {
        System.out.println(user+" 의 정보가 잘 저장 되었습니다.");
    }
}
