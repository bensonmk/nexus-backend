package com.bmk.nexus.exception;

import com.bmk.nexus.dto.response.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDto> handleEmailAlreadyExists(EmailAlreadyExistsException ex) {

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(new ErrorResponseDto(ex.getMessage(), null));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDto> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {

        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();

        Map<String, String> errors = new HashMap<>();

        fieldErrors.forEach((error) -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });

        return ResponseEntity
                .badRequest()
                .body(new ErrorResponseDto("Validation failed", errors));
    }
}
