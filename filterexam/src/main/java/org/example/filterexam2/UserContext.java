package org.example.filterexam2;
// ThreadLocal 을 이용해서 필요한 정보를 저장하는데
// 이 ThreadLocal 을 가지는 객체

public class UserContext {
    // 아직 null로 초기화.. 
    private static final ThreadLocal<User> USER_THREAD_LOCAL = ThreadLocal.withInitial(()->null);

    public static void setUser(User user) {
        USER_THREAD_LOCAL.set(user);
    }

    public static User getUser() {
        return USER_THREAD_LOCAL.get();
    }
}
