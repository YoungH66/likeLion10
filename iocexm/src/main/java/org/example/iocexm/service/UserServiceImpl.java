package org.example.iocexm.service;

import org.example.iocexm.dao.UserDao;
import org.example.iocexm.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("userService")
public class UserServiceImpl implements UserService{
    // autowired를 필드에 걸어서 사용할 수 있다. 필드 기반 주입. 단, 지양하는 방식임
//    @Autowired
    private UserDao userDao;

    // setter를 사용하지 않을때
    // 생성자 주입을 위해서 필요
//    @Autowired
//    public UserServiceImpl(UserDao userDao) {
//        this.userDao = userDao;
//    }


    // 설정자 주입 위해서 필요
    // component 사용할때 기본은 생성자 주입이라 autowired 붙이면 설정자 주입으로 할 수 있음.
    @Autowired
    @Qualifier("userCaramiDaoImpl")
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void joinUser(User user) {
        //회원가입을 위한 비지니스 코드가 작성되어야함..

        //회원가입을 위한 비지니스가 수행되면.. 해당 데이터를 저장하는 코드가 실행
        userDao.addUser(user);
    }
}
