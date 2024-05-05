package ru.azarkin.translateApi.exception;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RequiredArgsConstructor
@RestControllerAdvice
public class ErrorHandlingControllerAdvice {
    @ExceptionHandler({BadRequestException.class, MissingServletRequestParameterException.class, HttpMessageNotReadableException.class, MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError onBadRequestException(Exception e) {
        log.error(e.toString());
        return new ApiError("Request is incorrect", e, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({DeserializationException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiError onDeserializationException(Exception e) {
        log.error(e.toString());
        return new ApiError("Request is incorrect", e, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
