package com.uh.exception.handler;

import com.uh.dto.Error;
import com.uh.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UHExceptionControllerAdvice {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Error> handleProductNotFound(ProductNotFoundException e) {
        Error error = new Error();
        error.setErrorCode("a0001");
        error.setErrorMessage("Product doesnt exist");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
