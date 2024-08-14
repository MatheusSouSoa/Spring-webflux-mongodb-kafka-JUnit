package br.com.udemy.tasks.domain.model;

import br.com.udemy.tasks.application.service.TaskService;
import br.com.udemy.tasks.domain.enums.TaskState;
import lombok.*;

@Getter
@ToString
@EqualsAndHashCode
public class Task {

    private String title;
    private String description;
    private int priority;
    private TaskState state;

    public Task() {
    }

    public Task(Builder builder) {
        this.title = builder.title;
        this.priority = builder.priority;
        this.description = builder.description;
        this.state = builder.state;
    }

    public Task newTask() {
        TaskService.taskList.add(this);
        return this;
    }

    public Task insert() {
        return Task.builderFrom(this)
                .withState(TaskState.INSERT)
                .build();
    }

    public static Builder builder() {
       return new Builder();
    }

    public static Builder builderFrom(Task task) {
       return new Builder(task);
    }

    public static class Builder {
        private String title;
        private String description;
        private int priority;
        private TaskState state;

        public Builder() {
        }

        public Builder(Task task) {
            this.title = task.title;
            this.description = task.description;
            this.state = task.state;
            this.priority = task.priority;
        }

        public Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder withPriority (int priority) {
            this.priority = priority;
            return this;
        }

        public Builder withState (TaskState state) {
            this.state = state;
            return this;
        }

        public Task build() {
            return new Task(this);
        }
    }
}
