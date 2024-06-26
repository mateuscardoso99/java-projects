package com.example;

public class AuthService {
    private final Handler handler;

    public AuthService(Handler handler) {
        this.handler = handler;
    }

    public boolean login(String email, String password) {
        if (handler.handle(email, password)) {
            System.out.println("Authorization was successful!");
            // Do stuff for authorized users
            return true;
        }
        return false;
    }
}
