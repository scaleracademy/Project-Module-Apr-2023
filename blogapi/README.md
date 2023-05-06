




/users/24/articles 🔵 						[{}, {}, ....]

/articles?authorId=24 🟢					[{}, {}, ....]


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