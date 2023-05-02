package com.scaler.taskmanager.tasks.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class UpdateTaskDTO {
    Date dueDate;
    Boolean completed;
}
