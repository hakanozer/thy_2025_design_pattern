package com.works.configs;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.InvalidPropertiesFormatException;
import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalException {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidPropertiesFormatException.class)
    public Map invalidPropertiesFormat(InvalidPropertiesFormatException e ) {
        Map map = new LinkedHashMap();
        map.put("status", HttpStatus.BAD_REQUEST.value());
        map.put("result", e.getMessage());
        return map;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNotValid(MethodArgumentNotValidException e ) {
        return new ResponseEntity(e.getFieldErrors(), HttpStatus.BAD_REQUEST);
    }

}
