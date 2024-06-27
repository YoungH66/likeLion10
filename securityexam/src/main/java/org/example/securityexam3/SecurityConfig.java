package org.example.securityexam3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .authorizeRequests(authroizeRequest -> authroizeRequest
                        .requestMatchers("/shop/**", "/test").permitAll()   // 이때 지정한 페이지는 누구든지 접근 가능
                        .requestMatchers("/user/mypage").hasRole("USER")    // USER인 사용자만 접근 허용
                        .requestMatchers("/admin/abc").hasRole("ADMIN")     // ADMIN인 사용자만 접근 허용
                        .requestMatchers("/admin/**").hasAnyRole("ADMIN", "SUPERUSER")  // ADMIN, SUPERUSER 접근 허용
                        .anyRequest() //모든 요청
                        .authenticated() //인증을 요구
                )
                .formLogin(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // 실제 프로젝트에서는 이 부분을 사용하는 DB에 있는 사용자 정보를 이용할 수 있도록 작성 필요
        UserDetails user = User.withUsername("user")
                .password(passwordEncoder().encode("1234"))
                .roles("USER")
                .build();
        UserDetails admin = User.withUsername("admin")
                .password(passwordEncoder().encode("1234"))
                .roles("ADMIN")
                .build();
        UserDetails superuser = User.withUsername("superuser")
                .password(passwordEncoder().encode("1234"))
                .roles("SUPERUSER")
                .build();

        return new InMemoryUserDetailsManager(user, admin, superuser);
    }
}
