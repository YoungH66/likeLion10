package org.example.message2;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(ServiceConfig.class)    // 이 mainconfig가 serviceconfig를 가지고 있는것처럼 import
public class MainConfig {
    // 추가적인 설정 가능

    MainConfig(){
        System.out.println("MainConfig 생성");
    }
}
