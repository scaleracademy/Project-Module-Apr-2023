# Spring Boot Basic Project 

## Development 

### Test API 

There is [a postman collection](./TaskManager.postman_collection.json) to test the API

## Assignment

### 03. Make a Task Manager (only  Controller)

#### Project Description

Make a Task Manager with the following features:

- Create a task
  - Error if name is missing
  - Error if due date is missing or invalid (before today)
- List all tasks
- Fetch a task by id
  - Respond with 404 if task is not found
- Update a task (status and due date can be updated)
  - Respond with 404 if task is not found
  - > HINT: `@PatchMapping("/{id}")` can be used to update a task by id
- Delete a task
  - Respond with 404 if task is not found
  - > HINT: `@DeleteMapping("/{id}")` can be used to delete a task by id

#### Submission Requirements 

- For this project, you can write all the code inside `TasksController`
- Separating out Services and Repository not required for this assignment 
- The tasks are stored in an ArrayList in the controller itself
  - Tasks list will get reset on every server restart; which is acceptable for this assignment

##### How to submit

- Create a new repository on your GitHub account
- Create a new Spring Boot project inside it
- Finish the tasks 
- Push the code to GitHub
- Submit the Github repo link [on this form](https://docs.google.com/forms/d/e/1FAIpQLSfYBoju84gWZNybklLwrqiATCiK_GkJvNIzlk-0A1tGH1rskQ/viewform?usp=sf_link)

#### Bonus Tasks 

1. Sort and filter functionality for list tasks 
   1. `GET /tasks?completed=true` should return all completed tasks
   2. `GET /tasks?completed=false` should return all incomplete tasks
   3. `GET /tasks?sort=dateDesc` should return all tasks sorted by due date
   4. `GET /tasks?sort=dateAsc` should return all tasks sorted by due date

2. Bulk Delete tasks which are completed to be implemented 
   1. `DELETE /tasks?completed=true` should delete all completed tasks