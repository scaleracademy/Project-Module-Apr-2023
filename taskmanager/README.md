# Task Manager 

## Class Notes


### REST APIs 

| URL Paths ➡️<br><br>⬇️ HTTP Methods | /tasks<br><br>(collection)                                                                                                              | /tasks/5<br><br>(resource or entity)                                                                                                                                                                                                                                                  |
|-----------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| GET                               | get all tasks in the collection <br><br>response is `[{...}, {...}, {...}]`                                                             | get a single entity specified by the id<br><br>response is `{...}`                                                                                                                                                                                                                    |
| POST                              | create a new entity in this collection<br>request body contains data to save<br><br>response is the newly saved object (or just its id) | ⚠️ typically not implemented<br><br>if implemented: usually to update a nested object<br><br>eg: /tasks/5 - contains a list of notes                                                                                                                                                   |
| PUT                               | ⚠️ typically not implemented                                                                                                             | create or update (overwrite) task with id = 5<br><br>request body contains new data to save <br>only saves the new data, existing data of task 5 is not kept<br><br>works even if task 5 does not exist already; will create new<br><br>response = newly saved/updated object `{...}` |
| PATCH                             | ⚠️ typically not implemented                                                                                                             | update the task (with id = 5)<br><br>request body contains all or some fields of task <br><br>only updates the changed fields, keeps unchanged fields<br><br>does not work if task id 5 does not already exist<br><br>response = newly updated object `{...}`                         |
| DELETE                            | ⚠️ typically not implemented<br><br>if implemented: to delete the whole collection <br>(DROP TABLE)                                      | delete task with id = 5 <br><br>response is the deleted object, or empty body                                                                                                                                                                                                         |


### PUT vs PATCH

existing data

{ a: 10, b: 20 }


request body
{ a: 11, b: 22}



PUT : result
{ a: 11, b: 22}

PATCH : result
{ a: 11, b: 22}

### HTTP Requests

HTTP Request

	Method		PATCH		
	Domain		example.com
	Path		/tasks
	Query		
	Headers		X-Api-Key: sdfdfsdf
	Body		{a: 10}


	
	Method		PUT		
	Domain		example.com
	Path		/tasks
	Query		
	Headers		X-Api-Key: sdfdfsdf
	Body		{a: 10}


### Low Level Servers

GET -> 		https://example.com/tasks
GET ->		http://example.com/notes



DNS : example.com -> 145.34.22.11
HTTP : PORT 80
HTTPS: PORT 443



145.34.22.11:80  
-> 	< bytes> => ungzip => decode UTF 8
```
->	
{
    method: 	GET
    path: 		/tasks
    headers: 	[key:value]
    body: 		< bytes >

}
```

LB
145.34.22.11:80
-> 145.34.22.12:80
-> 145.34.22.13:80


## Assignments 

### ASG 03 (v2.0) 

Complete the TODOS in this project. 
All todos are marked as `// TODO` in the code. 

Submit in same form as ASG 03
https://docs.google.com/forms/d/e/1FAIpQLSfYBoju84gWZNybklLwrqiATCiK_GkJvNIzlk-0A1tGH1rskQ/viewform