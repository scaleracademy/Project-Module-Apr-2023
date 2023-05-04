package com.scaler.taskmanager;

import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @PostMapping("")
    String hello(@RequestBody HelloBody helloBody) {
        return "Hello World!";
    }

    @Data
    public static class HelloBody {
        String name;
    }

    @ExceptionHandler(Exception.class)
    ResponseEntity<String> handleEmptyBody(Exception e) {
        return ResponseEntity.badRequest().body("idk - something wrong happened");
    }
}

