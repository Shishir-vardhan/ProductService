package com.productservice.productservice.controllers;

import com.productservice.productservice.dto.ExceptionDto;
import com.productservice.productservice.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ProductControllerAdvices {

    //Method-1 : By Creating ResponseEntity
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDto> handleProductNotFoundException(ProductNotFoundException productNotFoundException){

        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage(productNotFoundException.getMessage());
        exceptionDto.setHttpStatus(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }


    //Method-2 : Without Creating a ResponseEntity.
    //If you don't want to get a trace during get call in postman use @ResponseBody().
//    @ExceptionHandler(ProductNotFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    @ResponseBody()
//    public ExceptionDto handleProductNotFoundException(ProductNotFoundException productNotFoundException){
//
//        ExceptionDto exceptionDto = new ExceptionDto();
//        exceptionDto.setMessage(productNotFoundException.getMessage());
//        return exceptionDto;
//    }

}
