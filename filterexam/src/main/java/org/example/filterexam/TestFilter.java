package org.example.filterexam;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
@WebFilter(urlPatterns = "/user/*")
public class TestFilter implements Filter {
    public TestFilter() {
      log.info("TestFilter Constructor run:::::");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("TestFilter doFilter() << before run >> :::::");

        filterChain.doFilter(servletRequest, servletResponse);

        log.info("TestFilter doFilter() << after run >> ::::::");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("TestFilter init run:::::");
    }

    @Override
    public void destroy() {
        log.info("TestFilter destroy run:::::");
    }
}
