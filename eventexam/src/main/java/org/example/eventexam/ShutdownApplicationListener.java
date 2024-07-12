package org.example.eventexam;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

// 닫을 때
@Component
public class ShutdownApplicationListener implements ApplicationListener<ContextClosedEvent> {
    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println(":: Application Closed ::");

        // 종료되는 시점에 해야할 일이 있다면, 아래 구현..
    }
}
