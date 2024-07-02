package org.example.oauthexam.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "social_login_info")
@Getter@Setter
public class SocialLoginInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String provider;
    private String socialId;
    private LocalDateTime createAt;
    private String uuid;

    public SocialLoginInfo() {
        // 소셜 로그인한 시간, UUID
        // 소셜 로그인 이후에 특정한 시간까지만 추가작업을 가능하게 하기 위함
        this.createAt = LocalDateTime.now();
        this.uuid = UUID.randomUUID().toString();
    }
}
