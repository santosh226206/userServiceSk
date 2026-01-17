package com.layp.userService.exception;

public class ResourceExist extends RuntimeException {
    ResourceExist(){
        super();
    }
    public ResourceExist(String message) {
        super(message);
    }
}
