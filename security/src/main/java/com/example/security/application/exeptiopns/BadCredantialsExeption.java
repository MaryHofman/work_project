package com.example.security.application.exeptiopns;

public class BadCredantialsExeption  extends RuntimeException {
    public BadCredantialsExeption(String message){
        super(message);
    }
}
