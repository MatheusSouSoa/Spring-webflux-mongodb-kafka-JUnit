package br.com.udemy.tasks.infrastructure.web.dtos;

import br.com.udemy.tasks.domain.enums.TaskState;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Setter
@Getter
public class TaskListResponse {

    private String title;
    private String description;
    private int priority;
    private TaskState state;

}
