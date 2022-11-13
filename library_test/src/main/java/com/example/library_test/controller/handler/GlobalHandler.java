package com.example.library_test.controller.handler;

import com.example.library_test.service.dto.errors.ErrorMessage;
import com.example.library_test.service.dto.errors.StructuredError;
import org.hibernate.TransientPropertyValueException;
import org.postgresql.util.PSQLException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class GlobalHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(BAD_REQUEST)
    public ErrorMessage handle(IllegalArgumentException e){
        return new ErrorMessage(
                e.getMessage()
        );
    }

    @ExceptionHandler(TransientPropertyValueException.class)
    @ResponseStatus(BAD_REQUEST)
    public ErrorMessage handle(TransientPropertyValueException e){
        return new ErrorMessage(
                String.format("%s - not recognized", e.getPropertyName())
        );
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(BAD_REQUEST)
    public ErrorMessage handle(HttpRequestMethodNotSupportedException e){
        return new ErrorMessage(
                "CHECK URL"
        );
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(BAD_REQUEST)
    public ErrorMessage handle(HttpMessageNotReadableException e){
        return new ErrorMessage(
                e.getLocalizedMessage()
        );
    }

    @ExceptionHandler(PSQLException.class)
    @ResponseStatus(BAD_REQUEST)
    public ErrorMessage handle(PSQLException e){
        return new ErrorMessage(e.getServerErrorMessage().getDetail());
    }



    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(BAD_REQUEST)
    public StructuredError handle(ConstraintViolationException e){
        return new StructuredError(e.getConstraintViolations().stream()
                .map(exc -> new ErrorMessage(
                        exc.getPropertyPath().toString().split("\\.")[2],
                        exc.getMessage()))
                .collect(Collectors.toSet()));
    }
}
