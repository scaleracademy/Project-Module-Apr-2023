package com.scaler.taskmanager.tasks.dtos;

import lombok.*;

import java.util.Date;

@Data
public class CreateTaskDTO {
    String name;
    Date dueDate;
}
