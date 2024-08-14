package br.com.udemy.tasks.infrastructure.web.controllers;


import br.com.udemy.tasks.application.service.TaskService;
import br.com.udemy.tasks.domain.model.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;


    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public Mono<List<Task>> getTasks () {
        return taskService.list();
    }

    @PostMapping
    public Mono<Task> createTask(@RequestBody Task task) {
        return taskService.insert(task);
    }
}
