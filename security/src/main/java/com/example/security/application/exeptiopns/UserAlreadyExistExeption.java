package com.example.security.application.exeptiopns;

public class UserAlreadyExistExeption  extends RuntimeException {
    public UserAlreadyExistExeption(String message){
        super(message);
    }
}
