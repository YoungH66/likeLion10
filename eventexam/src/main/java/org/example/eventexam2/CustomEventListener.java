package org.example.eventexam2;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

// 2. 이벤트가 발생 했을 때 해야할 일 구현
@Component
public class CustomEventListener {

    @EventListener
    public void handleCustomEvent(CustomEvent event) {
        System.out.println("CustomEventListener handleCustomEvent.... " + event.getMessage());
        //
    }
}
