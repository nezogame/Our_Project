package com.ourproject.socialnetwork.exceptions;

import java.time.ZonedDateTime;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Builder
@Data
@AllArgsConstructor
public class ErrorResponse {
    private HttpStatus statusCode;
    private String message;
    private ZonedDateTime timestamp;
    private Map<String, Object> errors;
}