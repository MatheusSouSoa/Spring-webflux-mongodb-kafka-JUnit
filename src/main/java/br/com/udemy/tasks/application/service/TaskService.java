package br.com.udemy.tasks.application.service;

import br.com.udemy.tasks.domain.model.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    public static List<Task> taskList = new ArrayList<>();

    public Mono<Task> insert(Task task) {
        return Mono.just(task)
                .map(Task::insert)
                .flatMap(this::save);
    }

    public Mono<List<Task>> list () {
        return Mono.just(taskList);
    }

    public Mono<Task> save(Task task) {
        return Mono.just(task)
                .map(Task::newTask);
    }
}

//public class TaskService {
//
//    public static List<Task> taskList;
//    private final InsertTaskUseCase insertTaskUseCase;
//
//    public TaskService(InsertTaskUseCase insertTaskUseCase) {
//        this.insertTaskUseCase = insertTaskUseCase;
//    }
//
//    public Mono<Task> insert(Task task) {
//        return insertTaskUseCase.execute(task);
//    }
//}
