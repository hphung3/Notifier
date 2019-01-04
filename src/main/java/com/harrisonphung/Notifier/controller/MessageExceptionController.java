package com.harrisonphung.Notifier.controller;

import com.harrisonphung.Notifier.exception.NumberNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by harrisonphung on 1/4/19.
 */
@ControllerAdvice
public class MessageExceptionController {

    @ExceptionHandler(value = NumberNotFoundException.class)
    public @ResponseBody String numberNotFound(){
        return "Number Not Found";
    }

}
