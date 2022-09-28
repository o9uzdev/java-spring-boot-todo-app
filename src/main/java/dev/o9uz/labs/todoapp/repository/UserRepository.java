package dev.o9uz.labs.todoapp.repository;

import dev.o9uz.labs.todoapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
