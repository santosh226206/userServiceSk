package com.layp.userService.exception;

import com.layp.userService.domain.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@ControllerAdvice
public class GlobalResponseHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<UserResponse> handlerResourceNotFound(ResourceNotFoundException resourceNotFoundException){
        String message = resourceNotFoundException.getMessage();

        // Create a UserResponse using getters and setters
        UserResponse userResponse = new UserResponse();
//        userResponse.setMessage(message);  // Setting the message
//        userResponse.setSuccess(true);     // Setting the success field to true
//        userResponse.setStatus(HttpStatus.NOT_FOUND);  // Setting the status field to NOT_FOUND
            userResponse.setMessage(message);
            userResponse.setSuccess(true);
            userResponse.setStatus(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(userResponse, HttpStatus.NOT_FOUND);
    }
}
