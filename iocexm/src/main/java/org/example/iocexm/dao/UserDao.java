package org.example.iocexm.dao;

import org.example.iocexm.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;


public interface UserDao {
    public User getUser(String email);
    public List<User> getUsers();
    public void addUser(User user);

}
