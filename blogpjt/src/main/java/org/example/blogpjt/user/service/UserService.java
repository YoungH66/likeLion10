package org.example.blogpjt.user.service;

import lombok.RequiredArgsConstructor;
import org.example.blogpjt.user.domain.Role;
import org.example.blogpjt.user.domain.User;
import org.example.blogpjt.user.repository.RoleRepository;
import org.example.blogpjt.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Transactional
    public User registerUser(User user) {
        try {
            if (userRepository.existsByUsername(user.getUsername())) {
                throw new RuntimeException("Username already exists");
            }
            if (userRepository.existsByEmail(user.getEmail())) {
                throw new RuntimeException("Email already exists");
            }

            Role userRole = roleRepository.findByName("USER")
                    .orElseThrow(() -> new RuntimeException("Required USER role not found"));

            user.setRoles(Collections.singleton(userRole));
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRegistrationDate(LocalDateTime.now());

            User savedUser = userRepository.save(user);
            System.out.println("User saved to database: " + savedUser.getUsername());
            return savedUser;
        } catch (Exception e) {
            System.err.println("Error in registerUser: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("User registration failed", e);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .roles("USER")
                .build();
    }

    public boolean isUsernameExists(String username) {
        return userRepository.existsByUsername(username);
    }

    public boolean isEmailExists(String email) {
        return userRepository.existsByEmail(email);
    }
}