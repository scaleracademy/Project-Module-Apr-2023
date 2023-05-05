package com.scaler.springbasics.tasks;

import java.util.Date;

public class Task {

    Integer id;
    String name;
    Date dueDate;
    Boolean completed;

    public Task(Integer id, String name, Date dueDate, Boolean completed) {
        this.id = id;
        this.name = name;
        this.dueDate = dueDate;
        this.completed = completed;
    }

    public Integer getId() {
        return id;
    }

    public Task setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Task setName(String name) {
        this.name = name;
        return this;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public Task setDueDate(Date dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public Task setCompleted(Boolean completed) {
        this.completed = completed;
        return this;
    }
}
