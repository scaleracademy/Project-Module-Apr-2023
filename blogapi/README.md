

## API Discussions


/users/24/articles 🔵 						[{}, {}, ....]

/articles?authorId=24 🟢					[{}, {}, ....]

## DB Entities 

```
UserEntity {

	@OneToMany(fetch: EAGER)
	List<ArticleEntity> articles 🔵
}


ArticlesRepository {
List<ArticleEntity> findAllByAuthorId(UUID userId) 🟢
}



var user = usersService.findByUsername()
user.getArticles() 🔵

var articles = articlesService.findAllByAuthorId() 🟢 
```


## Dependency Injection Notes 

```
Application {

	switch (url.path) {
		case: "/users" 
			UserController {
				getUser() {
					UserService {
						getUser() {
							UserRepository {
								findUser() {
								 	
								}
							}
						}
					}
				}
			} 
		case: "/articles"
			articlesController.getArticles()
		case: "/comments"
			commentsController.getComments()
	
	}

}
```

```
Application {

	UserRepo userRepo = new UserRepo()
	Articles articlesRepo = new ArticlesRepo() 
	
	UserService userService = new UserService(userRepo)
	ArticlesService articlesService = new ArticlesService(articlesRepo, userRepo)
	
	UserController userController = new UserController(userService)
	ArticlesController articlesCongtroller = new ArticlesController(articlesService)
 
}


UserController {
	UserService userService
}

UserService {
	UsersRepository usersRepository
}
```

![](./docs/di-excalidraw.png)