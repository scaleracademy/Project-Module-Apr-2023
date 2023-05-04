package com.scaler.taskmanager;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionAdvice extends ResponseEntityExceptionHandler {

    /*
    This will handle RuntimeException and IllegalArgumentException
    generated from **ALL** controllers
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
