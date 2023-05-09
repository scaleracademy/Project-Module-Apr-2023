package com.scaler.arrays;

import java.util.ArrayList;
import java.util.List;

public class ArrayFiltering {
    static class Task {
        String name;
        Boolean completed;

        public Task(String name, Boolean completed) {
            this.name = name;
            this.completed = completed;
        }
    }

    public static void main(String[] args) {

        List<Task> taskList = new ArrayList<>();
        taskList.add(new Task("Task 1", true));
        taskList.add(new Task("Task 2", false));
        taskList.add(new Task("Task 3", true));
        taskList.add(new Task("Task 4", false));
        taskList.add(new Task("Task 5", true));
        taskList.add(new Task("Task 6", false));

        // METHOD 1: Using an iterator
//        var iter = taskList.iterator();
//        while (iter.hasNext()) {
//            Task task = iter.next();
//            if (task.completed) {
//                iter.remove();
//            }
//        }

        // METHOD 2: Using filter
        List<Task> tempList = taskList.stream().filter(task -> !task.completed).toList();
//        taskList = tempList;
        taskList.clear();
        taskList.addAll(tempList);

        taskList.forEach(task -> System.out.println(task.name));

    }
}
