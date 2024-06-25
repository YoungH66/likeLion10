package org.example.filterexam2;

import jakarta.servlet.*;

import java.io.IOException;

public class UserFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            // 사용자가 요청하면서 보낸 값이 있다면 추출해서 UserContext 에 저장하는 코드 구현
            User user = new User();
            user.setUsername("yh");
            user.setPassword("123456");

            UserContext.setUser(user); // UserContext 에 값을 저장했을때, 이 값을 어디서 사용할 수 있을까

            filterChain.doFilter(servletRequest, servletResponse);
        }finally {
            UserContext.clear(); // 스레드풀을 사용하므로, 기존에 사용됐던 스레드를 또 쓸 가능성이 있다.
            // 그때 ThreadLocal 에 값이 남아있으면 안된다.
        }
    }
}
