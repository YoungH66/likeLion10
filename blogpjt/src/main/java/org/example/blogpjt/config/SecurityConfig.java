package org.example.blogpjt.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // CSRF 보호 비활성화 (API 서버의 경우)
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/", "/register", "/login").permitAll()  // 이 경로들은 모든 사용자에게 허용
                        .anyRequest().authenticated()  // 그 외의 요청은 인증 필요
                )
                .formLogin(form -> form
                        .loginPage("/login")  // 커스텀 로그인 페이지 경로
                        .defaultSuccessUrl("/")  // 로그인 성공 후 리다이렉트 경로
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/")  // 로그아웃 성공 후 리다이렉트 경로
                        .permitAll()
                );

        return http.build();
    }
}