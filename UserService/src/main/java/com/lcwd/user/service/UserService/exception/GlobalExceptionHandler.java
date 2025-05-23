package com.lcwd.user.service.UserService.exception;

import com.lcwd.user.service.UserService.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundException ex){

        String message = ex.getMessage();
     //   ApiResponse response = ApiResponse.builder().message(message).sucess(true).staus(HttpStatus.NOT_FOUND).build();
        ApiResponse response = new ApiResponse();
        response.setMessage(message);
        response.setSucess(true);
        response.setStatus(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }
}
