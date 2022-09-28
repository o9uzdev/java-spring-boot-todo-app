package dev.o9uz.labs.todoapp;

import dev.o9uz.labs.todoapp.entity.Todo;
import dev.o9uz.labs.todoapp.entity.User;
import dev.o9uz.labs.todoapp.repository.TodoRepository;
import dev.o9uz.labs.todoapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoAppApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TodoRepository todoRepository;

	public static void main(String[] args) {
		SpringApplication.run(TodoAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setId(1L);
		user.setPassword("o9uz");
		user.setUsername("o9uz");

		Todo todo = new Todo();
		todo.setId(1L);
		todo.setContent("Go to cinema");

		user.getTodoList().add(todo);

		todoRepository.save(todo);
		userRepository.save(user);

	}
}
