package com.borges.handlers;

import com.borges.exceptions.EntityNotFoundException;
import com.borges.exceptions.StandardError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<StandardError> handleEntityNotFoundException(EntityNotFoundException e, HttpServletRequest request) {
        String error = "Recurso não encontrado.";
        StandardError apiError = new StandardError(Instant.now(), HttpStatus.NOT_FOUND.value(), error, e.getMsg(), request.getRequestURI());
        return new ResponseEntity<StandardError>(apiError, new HttpHeaders(), apiError.getStatus());
    }
}
