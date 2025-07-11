package com.example.security.application.exeptiopns;

public class AccountLockedExeption extends RuntimeException {
    public AccountLockedExeption(String message){
        super(message);
    }
}
