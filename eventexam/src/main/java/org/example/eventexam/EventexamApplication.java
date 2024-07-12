package org.example.eventexam;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class EventexamApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(EventexamApplication.class, args);
    }

    @Autowired
    private CustomEventPublisher publisher;

    @Override
    public void run(String... args) throws Exception {
//        log.info("command add :: hello");
        System.out.println("command add :: hello");
        publisher.publishEvent("hello");
    }
}
