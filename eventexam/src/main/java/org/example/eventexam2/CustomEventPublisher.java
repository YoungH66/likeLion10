package org.example.eventexam2;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomEventPublisher {
    // post-comment 예제였다면 이 클래스가 CommentService 였을 것임
    private final ApplicationEventPublisher publisher;

    // 댓글등록 하는 메소드
    public void publishEvent(final String message) {
        // 댓글 등록
        CustomEvent event = new CustomEvent(this, message);
        publisher.publishEvent(event);
    }
}
