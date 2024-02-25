package com.green.validationAndExceptionHandling.advice;

import com.green.validationAndExceptionHandling.excepitons.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class AppExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException exception) {
        Map<String,String> errMap = new HashMap<>();

        exception.getBindingResult().getFieldErrors().forEach(err->{
            errMap.put(err.getField(),err.getDefaultMessage());
        });

        return errMap;
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UserNotFoundException.class)
    public Map<String,String> handleBusinessException(UserNotFoundException exception) {
        Map<String,String> errMap = new HashMap<>();
        errMap.put("errMessage",exception.getMessage());
        return errMap;
    }
}
