package com.edu.bhos.snap.userservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundEx extends RuntimeException  {

    public UserNotFoundEx(String message) {
        super(message);
    }
}
