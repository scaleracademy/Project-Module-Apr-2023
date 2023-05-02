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

    // TODO 03: create a TaskReponseDTO and do not return Task entity directly

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

//      TODO 01: implement PATCH task
//    @PatchMapping("/{id}")
//    ResponseEntity<Task> updateTask(@PathVariable("id") Integer id, @RequestBody UpdateTaskDTO updateTaskDTO) {
//
//    }

//      TODO 02: implement DELETE task
//    @DeleteMapping("/{id}")
//    ResponseEntity<Void> deleteTask(@PathVariable("id") Integer id) {
//
//    }

    // TODO 07: also handle IllegalArgumentException (due date, name etc)
    // TODO 08: in error responses send the error message in a JSON object
    @ExceptionHandler(TasksService.TaskNotFoundException.class)
    ResponseEntity<String> handleTaskNotFoundException(TasksService.TaskNotFoundException e) {
        return ResponseEntity.notFound().build();
    }

}
