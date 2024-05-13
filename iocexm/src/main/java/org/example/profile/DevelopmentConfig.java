package org.example.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev") // 프로필 이름 설정
public class DevelopmentConfig {
    @Bean
    public DataService dataService() {
        return new DataService("dev env");
    }
}
