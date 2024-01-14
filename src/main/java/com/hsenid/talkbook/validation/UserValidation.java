package com.hsenid.talkbook.validation;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class UserValidation {
    @ResponseStatus(HttpStatus.BAD_REQUEST)              // for http status code : 400
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> UserDataInvalidException(MethodArgumentNotValidException ex) {
        Map<String, String> errorMap = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(fieldErr -> {
            errorMap.put(fieldErr.getField(), fieldErr.getDefaultMessage());
        });

        return errorMap;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)      // for http status code : 500
    @ExceptionHandler(DataAccessException.class)
    public String internalServerErrorHandler (DataAccessException ex){
        ex.printStackTrace();
        String errorStackTrace = ex.getRootCause().getMessage()!=null?ex.getRootCause().getMessage():"Unknown SQL error occurred";
        return errorStackTrace;
    }
}


