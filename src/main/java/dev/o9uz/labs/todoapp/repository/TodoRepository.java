package dev.o9uz.labs.todoapp.repository;

import dev.o9uz.labs.todoapp.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}