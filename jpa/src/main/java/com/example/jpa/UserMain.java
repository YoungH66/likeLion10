package com.example.jpa;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class UserMain {
//    private static final Logger log = LoggerFactory.getLogger(UserMain.class);
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        //findUser()
        log.info("findUser() test===================");
        User findUser = userDAO.findUser(1L);
        log.info("Founded user : " + findUser.getName());

        User findUser2 = userDAO.findUser(1L);

        if(findUser == findUser2)
            log.info("finUser == findUser2");
        else log.info("finUser != findUser2");

//        User yhUser = new User("yhUser", "yhUser@exam.com");
//
//        userDAO.createUser(yhUser);
//        log.info("Created user: " + yhUser.getName());
//        log.info("user email : {}", yhUser.getEmail());
    }
}
