package org.example.eventexam;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

import java.time.Clock;
// 1. 이벤트 정의
// 2.
@Getter
@Setter
public class CustomEvent extends ApplicationEvent {
    private String message;

    public CustomEvent(Object source,String message) {
        super(source);
        this.message = message;
    }
}
