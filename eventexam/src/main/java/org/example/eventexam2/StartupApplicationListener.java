package org.example.eventexam2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class StartupApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println(":: Application started :: ");
        ApplicationContext context = event.getApplicationContext();
        // 컨텍스트가 로딩될 때, 할 일이 있다면, 이렇게 구현하면 스프링부트가 알아서 실행함

    }
}
