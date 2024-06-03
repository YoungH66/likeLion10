package org.example.restexam.controller;

import lombok.RequiredArgsConstructor;
import org.example.restexam.domain.Todo;
import org.example.restexam.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @GetMapping
    public List<Todo> getTodos() {
        return todoService.getTodos();
    }

    @GetMapping("/{id}")
    public Todo getTodo(@PathVariable("id") Long id){
        return todoService.getTodo(id);
    }

    @PostMapping
    public Todo addTodo(@RequestBody Todo todo){
        return todoService.addTodo(todo.getTodo());
    }

    // put vs patch -- 수정 || put은 전제 내용을 수정할때, patch는 일부를 수정할 때
    @PatchMapping("/{id}")
    public Todo updateById(@PathVariable("id") Long id){
        return todoService.updateTodo(id);
    }

    @PatchMapping
    public Todo updateTodo(@RequestBody Todo todo){
        return todoService.updateTodo(todo);
    }

    @DeleteMapping
    public String deleteTodo(@PathVariable("id") Long id){
        todoService.deleteTodo(id);
        return "ok";
    }
}
