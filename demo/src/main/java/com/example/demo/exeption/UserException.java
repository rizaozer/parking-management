package com.example.demo.exeption;

public class UserException extends AppException {

    public UserException(String message){
        super(message);
    }

    public UserException(Exception e){
        super(e);
    }
}
