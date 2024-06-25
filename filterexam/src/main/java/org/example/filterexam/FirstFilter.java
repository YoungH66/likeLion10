package org.example.filterexam;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
// 필터 자체를 요청 할 수 는 없다.
// 필터는 어떤 요청을 처리하기 전, 후 에 해야할 일들을 처리 할 수 있다.
// 필터도 사용되기 위해 Component 붙여야 함
@Slf4j
@Component
// WebFilter로 어느 url에 Filter를 적용할 지 지정할 수 도 있다.
@WebFilter(urlPatterns = "/hi")
public class FirstFilter implements Filter {

    public FirstFilter(){
        log.info("FirstFilter Constructor() run..");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("FirstFilter doFilter() << before run >> ::::::::");

        filterChain.doFilter(servletRequest, servletResponse);

        log.info("FirstFilter doFilter() << after run >> :::::::::");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("FirstFilter init() run...");
    }

    @Override
    public void destroy() {
        log.info("FirstFilter destroy() run..");
    }
}
