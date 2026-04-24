package com.example.linkshrinks.exception;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String handleValidationException(MethodArgumentNotValidException ex){
        return ex.getBindingResult()
                .getFieldError()
                .getDefaultMessage();
    }
    @ExceptionHandler(UrlNotFoundException.class)
    public Map<String, String> handleUrlNotFound(UrlNotFoundException ex){
        return Map.of("error", ex.getMessage());
    }
    @ExceptionHandler(UrlAlreadyExistsException.class)
    public Map<String, String> handleDuplicate(UrlAlreadyExistsException ex){
        return Map.of("error", ex.getMessage());
    }
    @ExceptionHandler(InvalidUrlException.class)
    public Map<String, String> handleInvalid(InvalidUrlException ex){
        return Map.of("error", ex.getMessage());
    }
}
