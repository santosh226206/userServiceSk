package com.layp.userService.exception;

public class ResourceNotFoundException extends RuntimeException{
    ResourceNotFoundException(){
        super();
    }
    public ResourceNotFoundException(String message){
        super(message);
    }
}
