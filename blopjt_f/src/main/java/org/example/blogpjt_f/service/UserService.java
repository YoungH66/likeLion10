package org.example.blogpjt_f.service;

import org.example.blogpjt_f.dto.UserDto;
import org.example.blogpjt_f.entity.User;
import org.example.blogpjt_f.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerNewUser(UserDto userDto) throws Exception {
        if (isUsernameExists(userDto.getUsername())) {
            throw new Exception("Username already exists");
        }
        if (isEmailExists(userDto.getEmail())) {
            throw new Exception("Email already exists");
        }

        User user = new User();
        user.setName(userDto.getName());
        user.setUsername(userDto.getUsername().trim());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setEmail(userDto.getEmail().trim());
        return userRepository.save(user);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }

    // 필요한 경우 사용자 저장 메서드 추가
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public boolean isUsernameExists(String username) {
        if (username == null || username.trim().isEmpty()) {
            return false;
        }
        return userRepository.findByUsername(username.trim()).isPresent();
    }

    public boolean isEmailExists(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        return userRepository.findByEmail(email.trim()).isPresent();
    }
}