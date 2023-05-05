package com.scaler.taskmanager.tasks;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class Task {
    Integer id;
    String name;
    @Setter
    Date dueDate;
    @Setter
    Boolean completed;
}
