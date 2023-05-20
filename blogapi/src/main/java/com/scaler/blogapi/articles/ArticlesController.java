package com.scaler.blogapi.articles;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/articles")
public class ArticlesController {

    @GetMapping("")
    ResponseEntity<String> getAllArticles() {
        // TODO 05:
        //  1. call articlesService.getAllArticles()
        //  2. respond with 200 OK and list of articles

        // TODO 07:
        //  1. add filter by author id `?authorId=1`
        //  2. add filter by tag `?tag=java`
        //  3. add sort by date `?sortBy=date`
        //  4. add filter by date range `?from=2021-01-01&to=2021-01-31`
        return ResponseEntity.ok("All articles");
    }

    @GetMapping("/{id}")
    ResponseEntity<Void> getArticleById() {
        // TODO 06:
        //  1. call articlesService.getArticleById()
        //  2. respond with 200 OK and article details
        return null;
    }

    @PostMapping("")
    ResponseEntity<String> createArticle() {
        // TODO 08:
        //  1. create a ArticleCreateDTO (containing title, description, body, tags)
        //  2. call articlesService.createArticle() with those details
        //  3. check that client sends a token which validates user is logged in
        //  4. respond with 202 ACCEPTED if article is created successfully
        return ResponseEntity.accepted().body("Article created successfully");
    }

    @PatchMapping("/{id}")
    ResponseEntity<Void> updateArticle() {
        // TODO 09:
        //  1. create a ArticleUpdateDTO (containing title, description, body, tags)
        //  2. call articlesService.updateArticle() with those details
        //  3. check that client sends a token which validates this user
        //  4. respond with 202 ACCEPTED if article is updated successfully
        return null;
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteArticle() {
        // TODO 10:
        //  1. call articlesService.deleteArticle()
        //  2. check that client sends a token which validates this user
        //  3. respond with 202 ACCEPTED if article is deleted successfully
        return null;
    }

    @PutMapping("/{id}/like")
    ResponseEntity<Void> likeArticle() {
        // TODO 11:
        //  1. call articlesService.likeArticle()
        //  2. check that client sends a token which validates this user
        //  3. respond with 202 ACCEPTED if article is liked successfully
        return null;
    }

    @DeleteMapping("/{id}/like")
    ResponseEntity<Void> unlikeArticle() {
        // TODO 12:
        //  1. call articlesService.unlikeArticle()
        //  2. check that client sends a token which validates this user
        //  3. respond with 202 ACCEPTED if article is unliked successfully
        return null;
    }
 }
