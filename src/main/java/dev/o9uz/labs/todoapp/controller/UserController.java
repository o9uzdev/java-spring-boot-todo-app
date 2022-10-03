package dev.o9uz.labs.todoapp.controller;

import dev.o9uz.labs.todoapp.entity.Todo;
import dev.o9uz.labs.todoapp.entity.User;
import dev.o9uz.labs.todoapp.repository.TodoRepository;
import dev.o9uz.labs.todoapp.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserRepository userRepository;
    private TodoRepository todoRepository;

    public UserController(UserRepository userRepository, TodoRepository todoRepository) {
        this.userRepository = userRepository;
        this.todoRepository = todoRepository;
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Long userId){
        return userRepository.findById(userId).orElseThrow(()-> new NoSuchElementException());
    }

    @PostMapping
    public User addUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @PostMapping("/userId/todos")
    public void addTodo(@PathVariable Long userId, @RequestBody Todo todo){
        User user = userRepository.findById(userId).orElseThrow(()->new NoSuchElementException());
        user.getTodoList().add(todo);
    }

    @PostMapping("/todos/{todoId}")
    public void toggleTodoCompleted(@PathVariable Long todoId){
        Todo todo = todoRepository.findById(todoId).orElseThrow(()->new NoSuchElementException());
        todo.setCompleted(!todo.getCompleted());
        todoRepository.save(todo);
    }

    @DeleteMapping("todos/{todoId}")
    public void deleteTodo(@PathVariable Long todoId){
        Todo todo = todoRepository.findById(todoId).orElseThrow(()->new NoSuchElementException());
        todoRepository.delete(todo);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId){
        User user = userRepository.findById(userId).orElseThrow(()->new NoSuchElementException());
        userRepository.delete(user);
    }
}
