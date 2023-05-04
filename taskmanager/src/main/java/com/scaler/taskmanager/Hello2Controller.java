package com.scaler.taskmanager;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class Hello2Controller {

     // THIS WILL GIVE AN ERROR
//    @PostMapping("")
//    String hello() {
//        return "Hello World!";
//    }

    @GetMapping("")
    String hello() {
        return "Hello World!";
    }

    /*
    Case: One exception handler, multiple types of exceptions
     */
    @ExceptionHandler(
            {
                    RuntimeException.class,
                    IllegalArgumentException.class
            }
    )
    String multiExceptionHandler(Exception e) {
        if (e instanceof IllegalArgumentException) {
            return "Illegal argument";
        } else if (e instanceof RuntimeException) {
            return "Something went wrong";
        } else {
            return "idk - something wrong happened";
        }
    }
}
