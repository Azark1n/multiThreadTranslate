package ru.azarkin.mocktranslate.exception;

import lombok.Value;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Value
public class ApiError {
    LocalDateTime timestamp;
    String status;
    String message;
    String reason;
    List<StackTraceElement> errors;

    public ApiError(String message, Exception exception, HttpStatus status) {
        this.timestamp = LocalDateTime.now();
        this.status = status.name();
        this.message = message;
        this.reason = exception.getMessage();
        this.errors = List.of(exception.getStackTrace());
    }
}
