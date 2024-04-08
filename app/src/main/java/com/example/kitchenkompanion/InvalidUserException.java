package com.example.kitchenkompanion;

public class InvalidUserException extends Exception {
    public InvalidUserException(Throwable err, String name) {
        super("The user "+name+" does not exist", err);
    }

    public InvalidUserException(String name) {
        super("The user "+name+" does not exist");
    }
}
