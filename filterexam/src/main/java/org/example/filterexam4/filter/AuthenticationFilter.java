package org.example.filterexam4.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Setter;
import org.example.filterexam4.entity.User;
import org.example.filterexam4.service.UserService;


import java.io.IOException;

@Setter
public class AuthenticationFilter implements Filter {
    private UserService userService;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            String path = request.getRequestURI();  // 요청주소 ex. /welcome, /loginform ...
            String auth = null;
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("auth")) {
                        auth = cookie.getValue();
                        break;
                    }
                }
            }
            // 인증된 사용자라면
            if(auth != null) {
                // 요청 url 에 따라서 http://localhost8080/admin -- Role 이 ROLE_ADMIN 인 사용자에게만 인가되도록

                User user = new User();
                user.setUsername(auth);

                UserContext.setUser(user);
            }
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            UserContext.clear();
        }
    }
}