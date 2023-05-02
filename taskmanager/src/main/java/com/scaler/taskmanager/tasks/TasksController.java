package com.scaler.taskmanager.tasks;

import com.scaler.taskmanager.tasks.dtos.CreateTaskDTO;
import com.scaler.taskmanager.tasks.dtos.UpdateTaskDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TasksController {
    private final TasksService tasksService;

    public TasksController(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @GetMapping("")
    ResponseEntity<List<Task>> getAllTasks() {
        var tasks = tasksService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{id}")
    ResponseEntity<Task> getTaskById(@PathVariable("id") Integer id) {
        var task = tasksService.getTaskById(id);
        return ResponseEntity.ok(task);
    }

    @PostMapping("")
    ResponseEntity<Task> createTask(@RequestBody CreateTaskDTO createTaskDTO) {
        var task = tasksService.createTask(createTaskDTO.getName(), createTaskDTO.getDueDate());
        return ResponseEntity.ok(task);
    }
//
//    @PatchMapping("/{id}")
//    ResponseEntity<Task> updateTask(@PathVariable("id") Integer id, @RequestBody UpdateTaskDTO updateTaskDTO) {
//
//    }
//
//    @DeleteMapping("/{id}")
//    ResponseEntity<Void> deleteTask(@PathVariable("id") Integer id) {
//
//    }

    @ExceptionHandler(TasksService.TaskNotFoundException.class)
    ResponseEntity<String> handleTaskNotFoundException(TasksService.TaskNotFoundException e) {
        return ResponseEntity.notFound().build();
    }

}
