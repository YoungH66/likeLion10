package org.example.filterexam4.service;

import lombok.RequiredArgsConstructor;
import org.example.filterexam4.entity.Role;
import org.example.filterexam4.entity.User;
import org.example.filterexam4.repository.RoleRepository;
import org.example.filterexam4.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    // 회원가입
    @Transactional(readOnly = false)
    public User register(User user) {
        // 회원가입을 위해서 Role을 알아서 Role 정보를 같이 넣어야 한다.
        // 이 메소드를 통해서 일반 회원을 등록할 수 있고, ROLE_USER로 Role을 얻어와 저장한다.
        Role userRole = roleRepository.findByName("ROLE_USER");
        user.setRoles(Collections.singleton(userRole));

        return userRepository.save(user);
    }

    //회원정보보기
    @Transactional(readOnly = true)
    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }
}
