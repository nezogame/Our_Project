package com.ourproject.socialnetwork.handler;

import com.mongodb.MongoWriteException;
import com.ourproject.socialnetwork.exceptions.ApiRequestException;
import com.ourproject.socialnetwork.exceptions.ErrorResponse;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.persistence.EntityNotFoundException;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(ApiRequestException.class)
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException ex) {
        ErrorResponse apiException = ErrorResponse.builder()
                .message(ex.getMessage())
                .statusCode(HttpStatus.BAD_REQUEST)
                .timestamp(ZonedDateTime.now())
                .build();
        return ResponseEntity
                .badRequest()
                .body(apiException);
    }

    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<Object> handleExpiredJwtException(ExpiredJwtException ex) {
        ErrorResponse apiException = ErrorResponse.builder()
                .message(ex.getMessage())
                .statusCode(HttpStatus.UNAUTHORIZED)
                .timestamp(ZonedDateTime.now())
                .build();
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(apiException);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Object> handleNoSuchElementException(NoSuchElementException ex) {
        ErrorResponse apiException = ErrorResponse.builder()
                .message(ex.getMessage())
                .statusCode(HttpStatus.NO_CONTENT)
                .timestamp(ZonedDateTime.now())
                .build();
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body(apiException);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException ex) {
        ErrorResponse apiException = ErrorResponse.builder()
                .message(ex.getMessage())
                .statusCode(HttpStatus.NOT_FOUND)
                .timestamp(ZonedDateTime.now())
                .build();
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(apiException);
    }

    @ExceptionHandler(MongoWriteException.class)
    public ResponseEntity<Object> handleMongoWriteException(MongoWriteException ex) {
        String errorMessage = "Error occurred during MongoDB write operation";
        ;

        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(errorMessage)
                .statusCode(HttpStatus.CONFLICT)
                .timestamp(ZonedDateTime.now())
                .build();
        Map<String, Object> errorDetails = new HashMap<>();
        errorDetails.put("exceptionMessage", ex.getMessage());
        errorDetails.put("errorCode", ex.getError().getCode());
        errorDetails.put("errorDetails", ex.getError().getDetails());
        errorResponse.setErrors(errorDetails);

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(errorResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMongoWriteException(MethodArgumentNotValidException ex) {
        Map<String, Object> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        ErrorResponse errorResponse = ErrorResponse.builder()
                .statusCode(HttpStatus.BAD_REQUEST)
                .message("Validation failed")
                .errors(errors)
                .timestamp(ZonedDateTime.now())
                .build();

        return ResponseEntity
                .badRequest()
                .body(errorResponse);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<Object> handleEmptyResultDataAccessException(EmptyResultDataAccessException ex) {
        Map<String, Object> errors = new HashMap<>();
        String fieldName = "id";
        errors.put(fieldName, ex.getLocalizedMessage());

        ErrorResponse errorResponse = ErrorResponse.builder()
                .statusCode(HttpStatus.BAD_REQUEST)
                .message("no results found")
                .errors(errors)
                .timestamp(ZonedDateTime.now())
                .build();

        return ResponseEntity
                .badRequest()
                .body(errorResponse);
    }
}
