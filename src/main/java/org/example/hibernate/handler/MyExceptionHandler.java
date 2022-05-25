package org.example.hibernate.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.*;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(value = {ConstraintViolationException.class})
    protected ResponseEntity<Object> validation(ConstraintViolationException ex) {

        Map<String, String> error = new LinkedHashMap<>();
        for (ConstraintViolation<?> o : ex.getConstraintViolations()) {
            error.put(o.getPropertyPath().toString(), o.getMessage());
        }
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
