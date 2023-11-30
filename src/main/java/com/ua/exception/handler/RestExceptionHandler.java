package com.ua.exception.handler;

import com.ua.exception.UserNotFoundException;
import com.ua.exception.UserUnauthorized;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    protected ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException exception) {
        return buildResponse(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserUnauthorized.class)
    protected ResponseEntity<Object> handleUserUnauthorized(UserUnauthorized exception) {
        return buildResponse(exception.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    private ResponseEntity<Object> buildResponse(String message, HttpStatus status){
        var body = new HashMap<>();
        body.put("message", message);
        body.put("status", status.value());
        body.put("error", status.getReasonPhrase());
        body.put("timestamp", LocalDateTime.now());
        return ResponseEntity.status(status).body(body);
    }

}
