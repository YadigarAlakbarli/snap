package com.edu.bhos.snap.userservice.exception;

import java.util.function.Supplier;

public class UserNotFoundEx extends RuntimeException  {

    public UserNotFoundEx(String message) {
        super(message);
    }
}
