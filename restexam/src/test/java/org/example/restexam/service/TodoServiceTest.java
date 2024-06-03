package org.example.restexam.service;

import org.example.restexam.domain.Todo;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@Transactional
class TodoServiceTest {
    @Autowired
    TodoService todoService;
    private static final Logger log = LoggerFactory.getLogger(TodoServiceTest.class);

    @Test
    void getTodos() {
        List<Todo> todos = todoService.getTodos();

        todos.forEach(todo -> log.info("Todo:::" + todo));
    }

    @Test
    void getTodo() {
        Todo todo = todoService.getTodo(1L);
        log.info("Todo:::" + todo);
    }

    @Test
    void addTodo() {
        Todo todo1 = todoService.addTodo("Todo5");
        log.info("Todo:::" + todo1);
    }

    @Test
    void updateTodo() {
        Todo todo = new Todo("update Todo");
        todo.setId(1L);
        log.info("Before UpateTodo:::" + todoService.getTodo(1L));
        todoService.updateTodo(todo);
        log.info("After UpateTodo::::" + todoService.getTodo(1L));
    }

    @Test
    void updateTodoById() {
        log.info("Before Todo:::::" + todoService.getTodo(1L));
        Todo todo = todoService.updateTodo(1L);
        log.info("After Todo::::::" + todo);
    }

    @Test
    void deleteTodo() {
        todoService.deleteTodo(1L);
        log.info("Todo:::" + todoService.getTodo(1L));
    }
}