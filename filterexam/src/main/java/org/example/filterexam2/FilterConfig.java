package org.example.filterexam2;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean // 필터를 등록할때 @ 방법보다 config 방법을 이용하면 좀 더 직관적이고 디테일한 설정이 가능해진다.
    public FilterRegistrationBean<UserFilter> authenticationFilter(){
        FilterRegistrationBean<UserFilter> registrationBean = new FilterRegistrationBean<>();
        UserFilter userFilter = new UserFilter();
        registrationBean.setFilter(userFilter);
        registrationBean.addUrlPatterns("/*");  // 모든 요청에 대해
        registrationBean.setOrder(1);   // 필터 실행시 우선 순위 설정. 낮은 숫자 우선
        return registrationBean;
    }
}
